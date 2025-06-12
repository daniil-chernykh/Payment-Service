package ru.hamming.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum RefundStatus {
    COMPLETED,
    FAILED;

    public static RefundStatus fromString(String status) {
        for (RefundStatus refundStatus : RefundStatus.values()) {
            if (refundStatus.toString().equalsIgnoreCase(status)) {
                return refundStatus;
            }
        }

        throw new IllegalStateException("Invalid RefundStatus" + status);
    }
}
