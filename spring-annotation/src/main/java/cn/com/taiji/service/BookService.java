package cn.com.taiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cn.com.taiji.dao.BookDao;

@Service
public class BookService {

	//明确指定扫描
	//@Qualifier("bookDao02")
	@Autowired
	private BookDao bookDao;
	
	
	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

	
	
	
}
