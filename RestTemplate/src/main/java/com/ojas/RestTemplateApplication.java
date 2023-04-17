package com.ojas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
//		RestTemplate t=new RestTemplate();
//		String url="http://localhost:9092/msg?sname=sai";
//		ResponseEntity<String> res=t.getForEntity(url, String.class);
//		int statusCode=res.getStatusCodeValue();
//		if(statusCode==200) {
//			System.out.println(res.getBody());
//		}
	}

}
