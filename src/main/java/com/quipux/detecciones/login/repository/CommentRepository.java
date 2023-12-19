package com.quipux.detecciones.login.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.quipux.detecciones.login.domain.Comment;
import com.quipux.detecciones.login.domain.PostId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

    // @Tailable
    Flux<Comment> findByPost(PostId id);

    Mono<Long> countByPost(PostId id);

}
