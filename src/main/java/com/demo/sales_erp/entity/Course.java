package com.demo.sales_erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
//@Document(collection = "online-course")
@Entity
@Table(name = "course_details")
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String instructor;
    private int amount;
    private int discountedAmount;
    private int duration;
    private int enrollmentCount;
    private String level;
    private String language;
}
