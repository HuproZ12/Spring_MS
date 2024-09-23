package org.example.ms_utilisateur.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor

@Entity @Table(name = "table_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String email;
}