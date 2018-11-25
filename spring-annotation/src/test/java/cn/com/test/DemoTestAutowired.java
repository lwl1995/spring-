package cn.com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.config.AutowiredCongfig;
import cn.com.taiji.dao.BookDao;
import cn.com.taiji.service.BookService;

public class DemoTestAutowired {

	@Test
	public void main() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredCongfig.class);
		BookService service = context.getBean(BookService.class);
		System.out.println(service);	
		
	}
}
