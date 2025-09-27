package br.com.gabriel.reactivedesignpatterns.record;

import java.math.BigDecimal;
import java.util.UUID;

public record User(UUID userId, BigDecimal balance) {
}
