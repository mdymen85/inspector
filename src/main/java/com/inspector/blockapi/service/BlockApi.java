package com.inspector.blockapi.service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 
 * Interceptor preHandle that executes before an endpoint execution.
 * 
 * @author mdymen
 *
 */
@Component
public class BlockApi implements HandlerInterceptor {		
	
	Logger logger = LoggerFactory.getLogger(BlockApi.class);
	
	@Value("${application.block-api.enable}")
	private Boolean blockApi;
	
	/**
	 * Executes a preHandle before a configured endpoint
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		var randomUUID = UUID.randomUUID();
		
		logger.info("UUID for the call {}", randomUUID);
		logger.info("Block API enable {}", blockApi);	
		
		if (!blockApi) logger.info("API {} will not be executed...", request.getRequestURI());
		
		return blockApi;
	}
	
}
