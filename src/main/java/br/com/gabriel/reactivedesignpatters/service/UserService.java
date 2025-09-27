package br.com.gabriel.reactivedesignpatters.service;

import java.util.UUID;
import br.com.gabriel.reactivedesignpatters.record.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final AccountService accountService;

    public UserService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Mono<User> getBalance() {
        final var userId = UUID.randomUUID(); // Generate a random UUID for the user. Simulating we are fetching userId from an authServer based on the token.
        return accountService.getAccountInformation(userId)
                             .map(account -> {
                                 // Create and return a new User record based on the account information
                                 return new User(userId, account.balance());
                             });
    }
}
