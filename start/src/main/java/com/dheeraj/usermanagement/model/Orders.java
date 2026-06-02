package com.dheeraj.usermanagement.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
    @Table(name = "Orders")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Orders {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;

        private String productName;

        private double price;
    }

