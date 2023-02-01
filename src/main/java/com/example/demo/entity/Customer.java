package com.example.demo.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerDocuments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    private String id;
    private String name;
    private double balance;
}
