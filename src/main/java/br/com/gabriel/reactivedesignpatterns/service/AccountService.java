package br.com.gabriel.reactivedesignpatterns.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.gabriel.reactivedesignpatterns.record.AccountInformation;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final WebClient webClient;

    public AccountService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<AccountInformation> getAccountInformation(UUID userId) {
        return webClient.get()
                        .uri("/api/account/{uuid}", userId)
                        .retrieve()
                        .bodyToMono(AccountInformation.class);
    }
}
