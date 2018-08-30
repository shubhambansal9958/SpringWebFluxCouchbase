package com.spring.webflux.service;

import org.hibernate.validator.internal.util.StringHelper;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.RxJavaCouchbaseOperations;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.query.N1qlQuery;
import com.spring.webflux.model.ChaptersWrapper;
import com.spring.webflux.model.Course;
import com.spring.webflux.model.HoursWrapper;
import com.spring.webflux.model.NameWrapper;
import com.spring.webflux.model.TutorNameWrapper;
import com.spring.webflux.repository.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public Mono<Course> save(Mono<Course> monoCourse) {
		return monoCourse.flatMap(course -> repository.save(course));
	}

	public Flux<Course> findAll() {
		return repository.findAll();
	}

	public Mono<Course> findById(int id) {
		return repository.findById(id);
	}

	public Flux<Course> findByName(String name) {
		return repository.findByName(name);
	}

	public Flux<Course> findByHoursRange(int lower, int upper) {
		return repository.findByHoursRange(lower, upper);
	}

	public Mono<Course> updateName(int id, Mono<NameWrapper> monoWrapper) {
		return monoWrapper.flatMap(wrapper -> {
			return repository.findById(id).flatMap(course -> {
				course.setName(wrapper.getName());
				return repository.save(course);
			});
		});
	}

	public Mono<Course> updateHours(int id, Mono<HoursWrapper> monoWrapper) {
		return monoWrapper.flatMap(wrapper -> {
			return repository.findById(id).flatMap(course -> {
				course.setHours(wrapper.getHours());
				return repository.save(course);
			});
		});
	}

	public Mono<Course> updateTutorName(int id, Mono<TutorNameWrapper> monoWrapper) {
		return monoWrapper.flatMap(wrapper -> {
			return repository.findById(id).flatMap(course -> {
				course.setTutorName(wrapper.getTutorName());
				return repository.save(course);
			});
		});
	}

	public Mono<Course> updateChapters(int id, Mono<ChaptersWrapper> monoWrapper) {
		return monoWrapper.flatMap(wrapper -> {
			return repository.findById(id).flatMap(course -> {
				course.setChapters(wrapper.getChapters());
				return repository.save(course);
			});
		});
	}
}
