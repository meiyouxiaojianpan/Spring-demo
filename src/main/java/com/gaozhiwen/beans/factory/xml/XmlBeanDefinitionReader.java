package com.gaozhiwen.beans.factory.xml;

import com.gaozhiwen.beans.BeanDefinition;
import com.gaozhiwen.beans.PropertyValue;
import com.gaozhiwen.beans.factory.BeanDefinitionStoreException;
import com.gaozhiwen.beans.factory.config.RuntimeBeanReference;
import com.gaozhiwen.beans.factory.config.TypedStringValue;
import com.gaozhiwen.beans.factory.support.BeanDefinitionRegistry;
import com.gaozhiwen.beans.factory.support.GenericBeanDefinition;
import com.gaozhiwen.core.io.Resource;
import com.gaozhiwen.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.spi.LoggerFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
*@author : gaozhiwen
*@date : 2018/6/25
*/
public class XmlBeanDefinitionReader {
    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SCOPE_ATTRIBUTE = "scope";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String NAME_ATTRIBUTE = "name";
    BeanDefinitionRegistry registry;
    protected final Log logger = LogFactory.getLog(getClass());

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinition(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                parsePropertyElement(ele, bd);
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from" + resource.getDescription(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parsePropertyElement(Element beanElem, BeanDefinition bd) {
        Iterator iter = beanElem.elementIterator(PROPERTY_ELEMENT);
        while (iter.hasNext()) {
            Element proElem = (Element) iter.next();
            String propertyName = proElem.attributeValue(NAME_ATTRIBUTE);
            if (!StringUtils.hasLength(propertyName)) {
                logger.fatal("Tag 'property' must have a 'name' attribute");
                return;
            }
            Object val = parsePropertyValue(proElem, bd, propertyName);
            PropertyValue pv = new PropertyValue(propertyName, val);
            bd.getPropertyValues().add(pv);
        }
    }

    private Object parsePropertyValue(Element ele, BeanDefinition bd, String propertyName) {
        String elementName = (propertyName != null) ?
                "<property> element for property '" + propertyName + "'" :
                "<constructor-arg> element";
        boolean hasRefAttribute = (ele.attribute(REF_ATTRIBUTE) != null);
        boolean hasValueAttribute = (ele.attribute(VALUE_ATTRIBUTE) != null);

        if (hasRefAttribute) {
            String refName = ele.attributeValue(REF_ATTRIBUTE);
            if (!StringUtils.hasLength(refName)) {
                logger.error(elementName + "contains empty 'ref' attribute");
            }
            RuntimeBeanReference ref = new RuntimeBeanReference(refName);
            return ref;
        } else if (hasValueAttribute) {
            TypedStringValue valueHolder = new TypedStringValue(ele.attributeValue(VALUE_ATTRIBUTE));
            return valueHolder;
        } else {
            throw new RuntimeException(elementName + " must specify a ref or value");
        }
    }
}
