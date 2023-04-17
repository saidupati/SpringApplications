package com.ojas;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ojas.pojo.SpringBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource(null)) ;
        SpringBean s=bf.getBean(null);
    }
}
