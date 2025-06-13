package ru.hamming.paymentservice.service.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hamming.paymentservice.service.handler.PaymentTransactionCommandHandler;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePaymentTransactionHandler implements PaymentTransactionCommandHandler {

    @Override
    public void process(String message, String requestId) {

    }
}
