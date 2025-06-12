package ru.hamming.paymentservice.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {
    private String number;
    private BigDecimal balance;
    private Long customerId; // ID владельца аккаунта(счета)
    // TODO: сделать Enum
    private String currency; // валюта в которой будут храниться деньги
}
