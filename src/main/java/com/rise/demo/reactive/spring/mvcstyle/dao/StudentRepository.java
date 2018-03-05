package com.rise.demo.reactive.spring.mvcstyle.dao;

import reactor.core.publisher.Mono;

public interface StudentRepository {

    Mono<Student> getStudent(Integer id);

    Mono<Student> saveStudent(Student student);
}
