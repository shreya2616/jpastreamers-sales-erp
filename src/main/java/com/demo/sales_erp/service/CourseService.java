package com.demo.sales_erp.service;

import com.demo.sales_erp.entity.Course;
import com.demo.sales_erp.repository.CourseRepository;
import com.demo.sales_erp.validation.Coursedto;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepo;

    public final JPAStreamer jpaStreamer;

    @Autowired
    public CourseService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    //business logic to get all the courses
    public List<Course> getAllCourse(){
        return courseRepo.findAll();
    }

    //business logic to get a single course with the help of id
    public Course getACourse(int id){
        return courseRepo.findById(id).get();
    }

    //business logic to add the course in the database
    public Course addCourse(Coursedto course){
        Course c = Course.builder()
                .name(course.getName())
                .level(course.getLevel())
                .amount(course.getAmount())
                .description(course.getDescription())
                .discountedAmount(course.getDiscountedAmount())
                .duration(course.getDuration())
                .enrollmentCount(course.getEnrollmentCount())
                .language(course.getLanguage())
                .instructor(course.getInstructor())
                .build();
        return courseRepo.save(c);
    }

    //business logic to get the course by language
    public List<Course> getCourseByLanguage(String language){
        return jpaStreamer.stream(Course.class)
                .filter(c -> c.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }

    //business logic to get all the courses by levels
    public List<Course> getCourseByLevels(String level){
        return jpaStreamer.stream(Course.class)
                .filter(c -> c.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }

    //business logic to update the course
    public Course editCourse(int id, Course newCourse){
        Optional<Course> optionalCourse= courseRepo.findById(id);
        if(optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            course.setAmount(newCourse.getAmount());
            course.setDescription(newCourse.getDescription());
            course.setDuration(newCourse.getDuration());
            course.setName(newCourse.getName());
            course.setInstructor(newCourse.getInstructor());
            course.setLevel(newCourse.getLevel());
            course.setDiscountedAmount(newCourse.getDiscountedAmount());
            course.setEnrollmentCount(newCourse.getEnrollmentCount());
            course.setLanguage(newCourse.getLanguage());
            return courseRepo.save(course);
        }
        throw new RuntimeException("Course not found!!");
    }

    //business logic to delete the course
    public void deleteCourse(int id){
        courseRepo.deleteById(id);
    }
}
