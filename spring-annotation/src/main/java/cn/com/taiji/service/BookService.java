package cn.com.taiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cn.com.taiji.dao.BookDao;

@Service
public class BookService {

	//��ȷָ��ɨ��
	//@Qualifier("bookDao02")
	@Autowired
	private BookDao bookDao;
	
	
	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

	
	
	
}
