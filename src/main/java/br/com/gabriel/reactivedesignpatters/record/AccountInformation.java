package br.com.gabriel.reactivedesignpatters.record;

import java.math.BigDecimal;

public record AccountInformation(String accountId, String accountType, BigDecimal balance) {
}