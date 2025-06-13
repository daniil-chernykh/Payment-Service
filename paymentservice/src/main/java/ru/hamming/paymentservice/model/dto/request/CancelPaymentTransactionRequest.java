package ru.hamming.paymentservice.model.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionRequest {

    @NotNull(message = "Transaction ID must not be null")
    private Long transactionId;

    @Min(value = 1, message = "Refund amount must not be null")
    @NotNull
    @Positive
    private BigDecimal refundedAmount;
    private String reasons;
}
