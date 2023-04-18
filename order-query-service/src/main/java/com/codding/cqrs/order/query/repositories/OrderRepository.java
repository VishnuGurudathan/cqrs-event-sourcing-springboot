package com.codding.cqrs.order.query.repositories;

import com.codding.cqrs.order.query.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author vishnu.g
 */
public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByOrderId(String orderId);
}
