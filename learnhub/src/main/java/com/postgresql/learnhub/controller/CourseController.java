package com.postgresql.learnhub.controller;

import com.postgresql.learnhub.DAO.CourseDAO;
import com.postgresql.learnhub.DTO.ResponseDTO;
import com.postgresql.learnhub.model.Courses;
import com.postgresql.learnhub.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("learnapp/api/course")
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("/allcourses")
    public ResponseEntity<ResponseDTO> allCourses(){
        return courseService.allCourse();
    }

    @PostMapping("/addcourse")
    public ResponseEntity<ResponseDTO> addCourse(@RequestBody Courses courses){
        return courseService.courseAddition(courses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteCourse(@PathVariable String id){
        return courseService.courseDeletion(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> courseDetails(@PathVariable String id){
        return courseService.courseDetail(id);
    }
}
