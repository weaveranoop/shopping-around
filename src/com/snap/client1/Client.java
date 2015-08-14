
package com.snap.client1;
import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snap.beans.*;
import com.snap.dao.*;

public class Client {
	private static 	AbstractApplicationContext fac;
	static{
		fac=new ClassPathXmlApplicationContext("hibernate.cfg.xml");
	}
public static void main(String[] args){
		
		DAO dao=fac.getBean("mydao",DAOImpl.class);
		UserBean ub=dao.getUser("tomarankit.nitb@gmail.com");
		System.out.println(ub.getName());
		
	} 
}

