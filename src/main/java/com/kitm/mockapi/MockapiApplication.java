package com.kitm.mockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "/")
public class MockapiApplication {

	int defaultResponseDelay = 0;
	final int MAX_RESPONSE_DELAY = 10000;

	// response status for simpleGet. HttpStatus.CREATED = 201
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.GET)
	String simpleGet(@RequestParam(name = "delay", required = false) String delay) throws InterruptedException {
		int responseDelay = defaultResponseDelay;
		if (delay != null) {
			try {
				responseDelay = Math.min(Integer.parseInt(delay), MAX_RESPONSE_DELAY);
			} catch (NumberFormatException ignored) {}
		}
		Thread.sleep(responseDelay);
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.PUT)
	void setDefaultResponseDelay(@RequestParam(name = "delay") String delay) {
		try {
			defaultResponseDelay = Math.min(Integer.parseInt(delay), MAX_RESPONSE_DELAY);
		} catch (NumberFormatException ignored) {}
	}

	public static void main(String[] args) {
		SpringApplication.run(MockapiApplication.class, args);
	}

}
