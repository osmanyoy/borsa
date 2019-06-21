package com.borsa.spring.aop;
import java.util.concurrent.Future;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class AOPConfig {

	@Async
	public Future<String> test(){
		return AsyncResult.forValue("test");
	}
	
    @Bean
    public Caller caller() {
        return new Caller();
    }

    @Bean
    public Callee callee() {
        return new Callee();
    }


}
