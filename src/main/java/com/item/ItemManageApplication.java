package com.item;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ItemManageApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/application.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

		SpringApplication.run(ItemManageApplication.class, args);
	}

}
