package com.codding.cqrs.payment.listeners;

import com.codding.cqrs.payment.dto.PaymentMessage;
import com.codding.cqrs.payment.utils.PaymentStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author vishnu.g
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaListenerComponent {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String PAYMENT_TOPIC = "payment_status_events";


    @KafkaListener(groupId = "new-payment-events-1", topics = "new_payment_event", containerFactory = "kafkaListenerContainerFactory")
    public void listenFromOrderTopic(String msg) throws JsonProcessingException, InterruptedException {
        log.info("Received ::  " + msg);
        processPayment(msg);
    }

    private void processPayment(String msg) throws JsonProcessingException, InterruptedException {
        PaymentMessage paymentMessage = objectMapper.readValue(msg, PaymentMessage.class);
        log.info("Payment is in progress for order id : " + paymentMessage.getOrderId());
        Thread.sleep(2000); // Assuming that payment process is going on for two seconds
        paymentMessage.setStatus(PaymentStatus.PAYMENT_SUCCESS.name()); // Based on payment status it will be set either success or failure
        paymentMessage.setTransactionId(UUID.randomUUID().toString());
        sendPaymentStatusEventOnKafka(paymentMessage);
    }

    private void sendPaymentStatusEventOnKafka(PaymentMessage paymentMessage) throws JsonProcessingException {
        kafkaTemplate.send(PAYMENT_TOPIC, objectMapper.writeValueAsString(paymentMessage));
    }
}