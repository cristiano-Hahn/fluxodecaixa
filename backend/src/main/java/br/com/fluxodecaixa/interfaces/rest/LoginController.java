package br.com.fluxodecaixa.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }
}
