package cn.com.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cn.com.taiji.dao.BookDao;



@Configuration
@ComponentScan({"cn.com.taiji.dao","cn.com.taiji.service","cn.com.taiji.controller"})
public class AutowiredCongfig {

	@Primary
	@Bean("bookDao02")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
}
