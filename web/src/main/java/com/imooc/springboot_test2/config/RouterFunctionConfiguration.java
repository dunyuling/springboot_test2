package com.imooc.springboot_test2.config;

import com.imooc.springboot_test2.domain.User;
import com.imooc.springboot_test2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Created by liux on 18-2-5.
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        Collection<User> collection = userRepository.findAll();
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"), request -> {
            Flux<User> userFlux = Flux.fromIterable(collection);
            return ServerResponse.ok().body(userFlux, User.class);
        });
    }

    /*
    request -> {
            Flux<User> userFlux = Flux.fromIterable(collection);
            return ServerResponse.ok().body(userFlux, User.class);
        }
     */
}
