package ru.hamming.paymentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hamming.paymentservice.model.enums.PaymentTransactionCommand;
import ru.hamming.paymentservice.service.handler.PaymentTransactionCommandHandler;
import ru.hamming.paymentservice.service.handler.impl.CancelPaymentTransactionHandler;
import ru.hamming.paymentservice.service.handler.impl.CreatePaymentTransactionHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentTransactionCommandConfig {

    @Bean
    public Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers(
            CreatePaymentTransactionHandler createPaymentTransactionHandler,
            CancelPaymentTransactionHandler cancelPaymentTransactionHandler
    ) {
        Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers = new HashMap<>();
        commandHandlers.put(PaymentTransactionCommand.CREATE, createPaymentTransactionHandler);
        commandHandlers.put(PaymentTransactionCommand.REFUND, cancelPaymentTransactionHandler);

        return commandHandlers;
    }
}
