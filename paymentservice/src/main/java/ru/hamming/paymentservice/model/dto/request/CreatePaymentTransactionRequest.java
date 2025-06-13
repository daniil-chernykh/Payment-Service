package ru.hamming.paymentservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTransactionRequest {

    @NotNull
    private Long sourceBankAccountId;
    private Long destinationBankAccountId;

    @NotNull
    @PositiveOrZero
    private BigDecimal amount;

    @NotNull
    private String currency;
    private String description;
}
