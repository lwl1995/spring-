package cn.com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.Person03Config;
import cn.com.taiji.bean.Person03;

public class DemoTestPerson03 {

	
	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Person03Config.class);
		Person03 bean = (Person03) context.getBean("person03");
		System.out.println(bean);
	}
	
}
