package com.rise.demo.reactive.spring.handlerstyle.dao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class DummyPersonRepository implements PersonRepository {

    private Map<Integer, Person> personCache = new HashMap<>();

    @Override public Mono<Void> save(Mono<Person> personMono) {
        return personMono.doOnNext( person -> {
           int id = personCache.size() +1;
           person.setId(id);
           personCache.put(id, person);
        }).thenEmpty(Mono.empty());
    }

    @Override public Flux<Person> getAll() {
        return Flux.fromIterable(personCache.values());
    }
}
