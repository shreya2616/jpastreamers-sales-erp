package com.demo.sales_erp.repository;

import com.demo.sales_erp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
