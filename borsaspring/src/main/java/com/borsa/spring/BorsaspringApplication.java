package com.borsa.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BorsaspringApplication {
	
	
	private IMyIntf abc;
	
	@Autowired
	public BorsaspringApplication(@Qualifier("abc") IMyIntf sss) {
		this.abc = sss;
		this.abc.execute("test");
	}
	
	@PostConstruct
	public void xyz() {
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BorsaspringApplication.class, args);
		BorsaspringApplication bean = run.getBean(BorsaspringApplication.class);
		bean.abc.execute("osman");
	}

}
