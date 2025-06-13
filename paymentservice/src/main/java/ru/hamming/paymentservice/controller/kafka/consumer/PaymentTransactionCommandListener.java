package ru.hamming.paymentservice.controller.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.hamming.paymentservice.model.enums.PaymentTransactionCommand;
import ru.hamming.paymentservice.service.handler.PaymentTransactionCommandHandler;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTransactionCommandListener {

    private final Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers;

    @KafkaListener(topics = "payment-command", containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentTransactionCommand(ConsumerRecord<String, String> record) {
        val command = getPaymentTransactionCommand(record);
        val handler = commandHandlers.get(command);

        if (handler == null) {
            throw new IllegalArgumentException("Unsupported payment transaction command, RECORD: " + record);
        }

        handler.process(record.value(), record.key());
    }

    private PaymentTransactionCommand getPaymentTransactionCommand(ConsumerRecord<String, String> record) {
        val commandHeader = record.headers().lastHeader("command");

        if (commandHeader != null) {
            return PaymentTransactionCommand.fromString(new String(commandHeader.value()));
        }
        return PaymentTransactionCommand.UNKNOWN;
    }

}
