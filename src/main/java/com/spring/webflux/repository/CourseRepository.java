package com.spring.webflux.repository;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.spring.webflux.model.Course;

import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveCouchbaseRepository<Course, Integer> {

	@Query("#{#n1ql.selectEntity} WHERE name = $1")
	public Flux<Course> findByName(String name);

	@Query("#{#n1ql.selectEntity} WHERE hours BETWEEN $1 AND $2")
	public Flux<Course> findByHoursRange(int lower , int upper);

}
