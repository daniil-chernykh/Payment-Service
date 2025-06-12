package ru.hamming.paymentservice.model.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.hamming.paymentservice.model.enums.RefundStatus;

@Converter
public class RefundStatusConverter implements AttributeConverter<RefundStatus, String> {
    @Override
    public String convertToDatabaseColumn(RefundStatus refundStatus) {
        return refundStatus == null ? null : refundStatus.name();
    }

    @Override
    public RefundStatus convertToEntityAttribute(String string) {
        return string == null ? null : RefundStatus.fromString(string);
    }
}
