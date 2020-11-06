package es.ostore.web.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.ostore.web.rest.RESTApp;

@SpringBootApplication(scanBasePackages = "es.ostore")
public class RESTApp {
	public static void main(String[] args) {
		SpringApplication.run(RESTApp.class, args);
	}
}
