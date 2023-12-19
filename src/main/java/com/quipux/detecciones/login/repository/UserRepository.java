/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quipux.detecciones.login.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.quipux.detecciones.login.domain.User;

import reactor.core.publisher.Mono;

/**
 * @author hantsy
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByUsername(String username);

}
