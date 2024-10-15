package com.add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringwithreactApplication {

	public static void main(String[] args) {
		ApplicationContext context=	SpringApplication.run(SpringwithreactApplication.class, args);
	
		UserRepo service=context.getBean(UserRepo.class);
		
//        UserService a =new UserService();
//        a.setfName("kapil");
//        a.setRoll(32);
//        a.setName("kapil");
//     service.save(a);
         
	}

}
