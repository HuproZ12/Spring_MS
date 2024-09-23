package org.example.ms_commande.repository;

import org.example.ms_commande.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(long id);
}