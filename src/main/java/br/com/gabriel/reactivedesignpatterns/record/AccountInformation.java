package br.com.gabriel.reactivedesignpatterns.record;

import java.math.BigDecimal;

public record AccountInformation(String accountId, String accountType, BigDecimal balance) {
}