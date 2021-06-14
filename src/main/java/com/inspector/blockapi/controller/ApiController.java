package com.inspector.blockapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspector.blockapi.service.BlockApi;

/**
 * 
 * Controller that has Api register with and interceptor 
 * and other Api without an interceptor
 * 
 * @author mdymen
 *
 */
@RestController
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);

	@GetMapping("/test")
	public void process(HttpServletRequest request, HttpServletResponse response) {
		logger.info("API {} executed...", request.getRequestURI());
	}
	
	@GetMapping("/test2")
	public void process2() {
		logger.info("API executed. Does not have blocking configuration...");
	}
	
}
