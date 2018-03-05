package com.rise.demo.reactive.spring.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import com.rise.demo.reactive.spring.handlerstyle.dao.DummyPersonRepository;
import com.rise.demo.reactive.spring.handlerstyle.PersonHandler;
import com.rise.demo.reactive.spring.handlerstyle.dao.PersonRepository;
import com.rise.demo.reactive.spring.mvcstyle.dao.DummyStudentRepository;
import com.rise.demo.reactive.spring.mvcstyle.dao.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebFluxConfiguration {

    @Bean
    public PersonRepository personRepository() {
        return new DummyPersonRepository();
    }

    @Bean
    public PersonHandler personHandler(PersonRepository personRepository) {
        return new PersonHandler(personRepository);
    }

    @Bean RouterFunction<ServerResponse> routerFunction(PersonHandler personHandler) {
        return route(POST("/persons").and(contentType(APPLICATION_JSON)), personHandler::create)
                .andRoute(GET("/persons").and(contentType(APPLICATION_JSON)), personHandler::getAll);
    }

    @Bean StudentRepository studentRepository() {
        return new DummyStudentRepository();
    }

}
