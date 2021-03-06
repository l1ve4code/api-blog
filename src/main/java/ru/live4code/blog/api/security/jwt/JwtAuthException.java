package ru.live4code.blog.api.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthException extends AuthenticationException {
    public JwtAuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthException(String msg) {
        super(msg);
    }
}
