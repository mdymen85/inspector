package com.inspector.blockapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.inspector.blockapi.service.BlockApi;

/**
 * 
 * Class that add interceptor for the Api /test
 * 
 * @author mdymen
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private BlockApi blockApiInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(blockApiInterceptor).addPathPatterns("/test");
	}
	
}
