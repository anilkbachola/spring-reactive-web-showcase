package com.rise.demo.reactive.spring.mvcstyle.dao;

import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class DummyStudentRepository implements StudentRepository {

    private Map<Integer, Student> studentCache = new HashMap<>();

    @Override public Mono<Student> getStudent(Integer id) {
        return Mono.just(studentCache.get(id));
    }

    @Override public Mono<Student> saveStudent(Student student) {
        Integer id = studentCache.size() +1;
        student.setId(id);
        studentCache.put(id, student);
        return Mono.just(student);
    }

}
