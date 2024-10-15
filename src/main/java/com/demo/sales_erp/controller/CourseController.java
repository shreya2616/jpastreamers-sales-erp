package com.demo.sales_erp.controller;

import com.demo.sales_erp.entity.Course;
import com.demo.sales_erp.service.CourseService;
import com.demo.sales_erp.validation.Coursedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    public CourseService courseService;

    //end point to add the course
    @PostMapping("/courses")
    public Course addCourse(Coursedto course){
        return courseService.addCourse(course);
    }

    //end point to get all the courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    //end point to get a single course by id
    @GetMapping("/api/{id}")
    public Course getACourse(int id){
        return courseService.getACourse(id);
    }

    //end point to get the list of courses based on language
    @GetMapping("/courses/language/{language}")
    public List<Course> getCourseByLanguage(@PathVariable String language){
        return courseService.getCourseByLanguage(language);
    }

    //end point to get all the courses based on level
    @GetMapping("/courses/level/{level}")
    public List<Course> getCourseByLevel(@PathVariable String level){
        return courseService.getCourseByLevels(level);
    }

    //end point to update the course
    @PutMapping("/courses/{id}")
    public Course editCourse(@PathVariable int id, @RequestBody Course newCourse){
        return courseService.editCourse(id, newCourse);
    }

    //end point to delete the course
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id){
       courseService.deleteCourse(id);
    }
}
