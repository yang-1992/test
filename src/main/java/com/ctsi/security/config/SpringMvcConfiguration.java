package com.ctsi.security.config;

import com.ctsi.ssdc.captcha.CaptchaHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer  {

	@Bean
	public CaptchaHandlerInterceptor captchaHandlerInterceptor() {
		return new CaptchaHandlerInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){

		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(captchaHandlerInterceptor());

	}
}
