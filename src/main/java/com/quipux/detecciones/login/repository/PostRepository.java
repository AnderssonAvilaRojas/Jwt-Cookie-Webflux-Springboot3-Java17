package com.quipux.detecciones.login.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.quipux.detecciones.login.domain.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

    Flux<Post> findByTitleContains(String q, Pageable pageable);

    Mono<Long> countByTitleContains(String q);

}
