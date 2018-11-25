package cn.com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.MainConfig;
import cn.com.taiji.bean.Person;

//注解注入bean的测试
public class DemoTestAnnotationConfig {
	
	@Test
	public void main() {			//返回对象也可以为ApplicationContext
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		String[] names = context.getBeanDefinitionNames();
		for(String string : names) {
			System.out.println(string);
		}
	}
	
}
