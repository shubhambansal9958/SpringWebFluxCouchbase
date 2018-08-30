package com.spring.webflux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.webflux.component.CourseHandler;

@Configuration
public class CourseRouter {

	@Bean
	public RouterFunction<ServerResponse> route(CourseHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.GET("/course"), handler::findAll)
				.andRoute(RequestPredicates.GET("/course/{id}"), handler::findById)
				.andRoute(RequestPredicates.GET("/course/name/{name}"), handler::findByName)
				.andRoute(RequestPredicates.GET("/course/hours/{from}/{to}"), handler::findByHoursRange)
				.andRoute(RequestPredicates.POST("/course"), handler::save)				
				.andRoute(RequestPredicates.POST("/course/{id}/name"), handler::updateName)
				.andRoute(RequestPredicates.POST("/course/{id}/hours"), handler::updateHours)
				.andRoute(RequestPredicates.POST("/course/{id}/tutorName"), handler::updateTutorName)
				.andRoute(RequestPredicates.POST("/course/{id}/chapters"), handler::updateChapters)
				;
	}
}
