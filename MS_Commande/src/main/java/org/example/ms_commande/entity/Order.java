package org.example.ms_commande.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor

@Entity @Table(name = "table_order")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long orderId;
    private long userId;
    private String product;
}