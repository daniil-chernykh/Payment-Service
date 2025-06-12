package ru.hamming.paymentservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hamming.paymentservice.model.enums.PaymentTransactionStatus;
import ru.hamming.paymentservice.model.enums.converter.PaymentTransactionStatusConverter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity{

    private BigDecimal amount;
    private String currency;

    @Convert(converter = PaymentTransactionStatusConverter.class)
    private PaymentTransactionStatus paymentTransactionStatus;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount; // откуда будут переводиться деньги
    @ManyToOne
    @JoinColumn(name = "destinationBankAccountId")
    private BankAccount destinationBankAccount; // куда будут переводиться деньги

    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;
}
