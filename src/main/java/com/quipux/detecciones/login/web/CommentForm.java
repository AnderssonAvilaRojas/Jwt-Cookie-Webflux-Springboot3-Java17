package com.quipux.detecciones.login.web;

import jakarta.validation.constraints.NotBlank;

public record CommentForm(
        @NotBlank
        String content

) {
}
