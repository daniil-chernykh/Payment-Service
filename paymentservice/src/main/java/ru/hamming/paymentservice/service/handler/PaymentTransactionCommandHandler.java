package ru.hamming.paymentservice.service.handler;

public interface PaymentTransactionCommandHandler {
    void process(String message, String requestId);
}
