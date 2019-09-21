package com.example.restTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
		System.out.println("Rest Template Example");
		RestTemplateApplication restTemplateApplication = new RestTemplateApplication();
		restTemplateApplication.callService();
	}

	private void callService() {
		final String uri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
		RestTemplate restTemplate = new RestTemplate();
		Weather result = restTemplate.getForObject(uri, Weather.class);
		System.out.println(result.getCoord().getLat() + " " + result.getCoord().getLon());
	}
}
