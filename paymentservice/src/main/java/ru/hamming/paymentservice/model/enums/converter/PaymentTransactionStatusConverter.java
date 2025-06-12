package ru.hamming.paymentservice.model.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.hamming.paymentservice.model.enums.PaymentTransactionStatus;

@Converter(autoApply = true)
public class PaymentTransactionStatusConverter implements AttributeConverter<PaymentTransactionStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentTransactionStatus paymentTransactionStatus) {
        return paymentTransactionStatus == null ? null : paymentTransactionStatus.name();
    }

    @Override
    public PaymentTransactionStatus convertToEntityAttribute(String string) {
        return string == null ? null : PaymentTransactionStatus.fromString(string);
    }
}
