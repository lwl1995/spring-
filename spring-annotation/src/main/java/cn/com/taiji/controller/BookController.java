package cn.com.taiji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.com.taiji.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void service() {
		System.out.println("Service.................");
	}
}
