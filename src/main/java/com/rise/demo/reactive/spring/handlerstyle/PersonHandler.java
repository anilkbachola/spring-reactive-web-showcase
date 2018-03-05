package com.rise.demo.reactive.spring.handlerstyle;

import com.rise.demo.reactive.spring.handlerstyle.dao.Person;
import com.rise.demo.reactive.spring.handlerstyle.dao.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonHandler {

    private final PersonRepository personRepository;

    public PersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        return ServerResponse.ok().build(personRepository.save(person));
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Person> personFlux = personRepository.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(personFlux, Person.class);
    }
}
