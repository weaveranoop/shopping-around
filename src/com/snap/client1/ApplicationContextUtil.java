package com.snap.client1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static AbstractApplicationContext fac;
	
	public static AbstractApplicationContext getAbstractApplicationContext() {
		fac = new ClassPathXmlApplicationContext("hibernate.cfg.xml");
		return fac;
	}
}
