package com.kitm.mockapi;

import com.kitm.mockapi.exceptions.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.stream.IntStream;
//import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@RestController
@RequestMapping(value = "/")
public class MockapiApplication {

	private int getDefaultResponseCode = 200;
	private int defaultResponseDelay = 0;
	private final int [] supportedResponseCodes = {200, 201, 204, 301, 400, 403, 404, 500, 503};
	private final int MAX_RESPONSE_DELAY = 10000;

	@RequestMapping(method = RequestMethod.GET)
	void simpleGet(@RequestParam(name = "delay", required = false) String delay,
					 @RequestParam(name = "code", required = false) String code) throws InterruptedException {
		//SecurityContextHolder.clearContext(); //<==== logout, doesn't work in chrome
		//********delay************************************************************************************
		int responseDelay = defaultResponseDelay;
		if (delay != null) {
			try {
				responseDelay = Math.max(Math.min(Integer.parseInt(delay), MAX_RESPONSE_DELAY), 0);
			} catch (NumberFormatException ignored) {}
		}
		Thread.sleep(responseDelay);
		//**********response code**************************************************************************
		int responseCode = getDefaultResponseCode;
		if (code != null) {
			try {
				responseCode = Integer.parseInt(code);
			} catch (NumberFormatException ignored) {}
		}
		switch (responseCode) {
			case 201:
				throw new Exception201();
			case 204:
				throw new Exception204();
			case 301:
				throw new Exception301();
			case 400:
				throw new Exception400();
			case 403:
				throw new Exception403();
			case 404:
				throw new Exception404();
			case 500:
				throw new Exception500();
			case 503:
				throw new Exception503();
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	void setDefaultResponseDelay(@RequestParam(name = "delay", required = false) String delay,
								 @RequestParam(name = "code", required = false) String code) {
		//***************delay****************************************************************************
		if (delay != null) {
			try {
				defaultResponseDelay = Math.max(Math.min(Integer.parseInt(delay), MAX_RESPONSE_DELAY), 0);
			} catch (NumberFormatException ignored) {}
		}
		//***************response code********************************************************************
		if (code != null) {
			int newCode = -1;
			try {
				newCode = Integer.parseInt(code);
			} catch (NumberFormatException ignored) {}
			final int finalNewCode = newCode;
			if (IntStream.of(supportedResponseCodes).anyMatch(x -> x == finalNewCode)) {
				getDefaultResponseCode = newCode;
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MockapiApplication.class, args);
	}

}
