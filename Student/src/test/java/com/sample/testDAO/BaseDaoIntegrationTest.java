package com.sample.testDAO;

import hthurow.tomcatjndi.TomcatJNDI;

import java.io.File;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class BaseDaoIntegrationTest extends AbstractJUnit4SpringContextTests {
	
	private static TomcatJNDI tomcatJNDI;   

	@BeforeClass
	public static void init(){	
		Properties prop = new Properties();
		tomcatJNDI = new TomcatJNDI();
		tomcatJNDI.processContextXml(new File(prop.getProperty("path")));
		tomcatJNDI.start();
	}
	
}
