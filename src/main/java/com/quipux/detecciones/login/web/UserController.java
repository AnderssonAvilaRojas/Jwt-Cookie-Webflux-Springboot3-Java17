package com.quipux.detecciones.login.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.detecciones.login.domain.User;
import com.quipux.detecciones.login.repository.UserRepository;

import reactor.core.publisher.Mono;

/**
 * @author hantsy
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository users;

    @GetMapping("/users/{username}")
    public Mono<User> get(@PathVariable() String username) {
        return this.users.findByUsername(username);
    }

}
