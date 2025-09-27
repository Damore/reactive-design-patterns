package br.com.gabriel.reactivedesignpatters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.gabriel.reactivedesignpatters.record.User;
import br.com.gabriel.reactivedesignpatters.service.UserService;
import reactor.core.publisher.Mono;

@RestController
public class BalanceController {

    private final UserService userService;

    public BalanceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/balance")
    public Mono<ResponseEntity<User>> getBalance() {
        return userService.getBalance()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
