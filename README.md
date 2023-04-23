# CQRS and Event Sourcing Implementation with Spring Boot and Axon Server

This repository contains an implementation of the Command Query Responsibility Segregation (CQRS) architecture using Spring Boot and Axon Server. The implementation includes Event Sourcing, which enables auditing and reconstructing of the aggregate state. The implementation is divided into three services: order-command-service, order-query-service, and payment-service.

## Services

* order-command-service: This service is responsible for handling commands for creating and updating orders. It publishes events to Axon Server and sends a payment request to the payment-service via Kafka.

* order-query-service: This service is responsible for handling queries related to orders. It subscribes to the events published by order-command-service on Axon Server and updates its own database accordingly.

* payment-service: This service is responsible for handling payment requests received from the order-command-service via Kafka. It publishes payment events to Axon Server.

## Kafka Setup

To run Kafka, you can use the Docker Compose file included in this repository.
```
docker-compose up -d
```

## Getting Started

To run the application, you need to have Java and Grade installed on your machine. Then, follow these steps:

   1. Clone the repository to your local machine
   2. Navigate to the project directory in the terminal/command prompt
   3. Run the following command: mvn clean spring-boot:run
   
The services will be available at the following ports:

    `order-command-service`: `http://localhost:8080`
    `order-query-service`: `http://localhost:8090`
    `payment-service`: `http://localhost:9000`

## Overview

The implementation follows the CQRS pattern, separating the read and write models. The write model is responsible for handling commands and generating events, which are then persisted to the event store. The read model is responsible for handling queries and returning the current state of the aggregates.

Axon Server is used as the messaging and event store platform, while Spring Boot provides the necessary infrastructure for building and running the application.
