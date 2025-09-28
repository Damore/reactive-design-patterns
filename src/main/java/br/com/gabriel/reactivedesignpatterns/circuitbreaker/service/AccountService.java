package br.com.gabriel.reactivedesignpatterns.circuitbreaker.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.gabriel.reactivedesignpatterns.record.AccountInformation;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AccountService {

    private final WebClient webClient;

    public AccountService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @CircuitBreaker(name = "account-api", fallbackMethod = "fallbackGetAccountInformation")
    public Mono<AccountInformation> getAccountInformation(UUID userId) {
        return webClient.get()
                        .uri("/api/account/{uuid}", userId)
                        .retrieve()
                        .bodyToMono(AccountInformation.class);
    }

/**
 * Fallback method for {@link #getAccountInformation(UUID)} when the circuit breaker is open or half open.
 *
 * @param userId the UUID of the user whose account information was requested
 * @param ex the exception thrown when the circuit breaker is open or half open
 * @return a {@link Mono} emitting a default {@link AccountInformation} instance
 */
public Mono<AccountInformation> fallbackGetAccountInformation(UUID userId, CallNotPermittedException ex) {
    log.error("Fallback called", ex);
    return Mono.just(new AccountInformation("00000", "DEFAULT_ACCOUNT", java.math.BigDecimal.ZERO));
}
}
