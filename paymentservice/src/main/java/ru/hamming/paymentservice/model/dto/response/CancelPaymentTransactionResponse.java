package ru.hamming.paymentservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hamming.paymentservice.model.dto.enums.CommandResultStatus;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionResponse {
    private Long refundId;
    private CommandResultStatus status;
    private String errorMessage;
}
