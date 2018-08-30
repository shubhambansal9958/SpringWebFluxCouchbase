package com.spring.webflux.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.webflux.model.ChaptersWrapper;
import com.spring.webflux.model.Course;
import com.spring.webflux.model.HoursWrapper;
import com.spring.webflux.model.NameWrapper;
import com.spring.webflux.model.TutorNameWrapper;
import com.spring.webflux.service.CourseService;

import reactor.core.publisher.Mono;

@Component
public class CourseHandler {

	@Autowired
	private CourseService service;

	public Mono<ServerResponse> save(ServerRequest request) {
		return ServerResponse.ok().body(service.save(request.bodyToMono(Course.class)), Course.class);
	}

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse.ok().body(service.findAll(), Course.class);
	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		return ServerResponse.ok().body(service.findById(Integer.parseInt(request.pathVariable("id"))), Course.class);
	}
	
	public Mono<ServerResponse> findByName(ServerRequest request) {
		return ServerResponse.ok().body(service.findByName(request.pathVariable("name")), Course.class);
	}
	
	public Mono<ServerResponse> findByHoursRange(ServerRequest request) {
		int lower = Integer.parseInt(request.pathVariable("from"));
		int upper = Integer.parseInt(request.pathVariable("to"));
		return ServerResponse.ok().body(service.findByHoursRange(lower, upper), Course.class);
	}

	public Mono<ServerResponse> updateName(ServerRequest request) {
		return ServerResponse.ok().body(
				service.updateName(Integer.parseInt(request.pathVariable("id")), request.bodyToMono(NameWrapper.class)),
				Course.class);
	}

	public Mono<ServerResponse> updateHours(ServerRequest request) {
		return ServerResponse.ok().body(
				service.updateHours(Integer.parseInt(request.pathVariable("id")), request.bodyToMono(HoursWrapper.class)),
				Course.class);
	}

	public Mono<ServerResponse> updateTutorName(ServerRequest request) {
		return ServerResponse.ok().body(
				service.updateTutorName(Integer.parseInt(request.pathVariable("id")), request.bodyToMono(TutorNameWrapper.class)),
				Course.class);
	}

	public Mono<ServerResponse> updateChapters(ServerRequest request) {
		return ServerResponse.ok().body(
				service.updateChapters(Integer.parseInt(request.pathVariable("id")), request.bodyToMono(ChaptersWrapper.class)),
				Course.class);
	}
}
