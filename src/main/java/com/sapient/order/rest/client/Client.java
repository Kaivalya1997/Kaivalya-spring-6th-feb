package com.sapient.order.rest.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:9000/orders", List.class);
		System.out.println(responseEntity.getBody());
	}

}
