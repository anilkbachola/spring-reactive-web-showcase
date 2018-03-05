package com.rise.demo.reactive.spring.handlerstyle.dao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Void> save(Mono<Person> person);

    Flux<Person> getAll();
}
