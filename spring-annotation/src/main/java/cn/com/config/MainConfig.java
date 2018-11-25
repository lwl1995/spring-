package cn.com.config;

import org.junit.internal.Classes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.sun.glass.ui.CommonDialogs.Type;

import cn.com.taiji.bean.Person;

//������==�����ļ�xml����������Ҫ��@Configurationע��
@Configuration
@ComponentScan(value = "cn.com.taiji",excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,classes= {Controller.class,Service.class})})//���ע���൱��<context:component-scan base-package=""></context:component-scan>,ɨ��@Controller @Service @Repository @Component���ĸ��κ�һ��ע��
public class MainConfig {

	@Bean("person02")             //������person02ΪPerson������ 
	public Person person() {      //Person��Ӧxml�ļ���class person��Ӧxml��id
		
		return new Person("liuwenlong",20);
	}
	
}
