package com.postgresql.learnhub.services;

import com.postgresql.learnhub.DAO.CourseDAO;
import com.postgresql.learnhub.DTO.ResponseDTO;
import com.postgresql.learnhub.model.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO){
        this.courseDAO=courseDAO;
    }

    public ResponseEntity<ResponseDTO> allCourse(){
        List<Courses> course=courseDAO.findAll();
        return ResponseEntity.ok(
                new ResponseDTO(HttpStatus.OK, "Retrieved all course from the table", course));
    }

    public ResponseEntity<ResponseDTO> courseAddition(Courses courses){
        if(courses.getCourseId()==null||courses.getCourseImage()==null||courses.getCourseName()==null){
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(HttpStatus.BAD_REQUEST,"Missing required fields",null));
        }
        else if(courseDAO.existsById(courses.getCourseId())){
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(HttpStatus.BAD_REQUEST,"Course Id already exists",null));
        }
        else{
            courseDAO.save(courses);
            return ResponseEntity.ok(
                    new ResponseDTO(HttpStatus.OK,"Updated Successdully!",null)
            );
        }
    }

    public ResponseEntity<ResponseDTO> courseDeletion(String courseId){
        if(!courseDAO.existsById(courseId)){
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(HttpStatus.FORBIDDEN,"Course does not exist.",null)
            );
        }
        else{
            courseDAO.deleteById(courseId);
            return ResponseEntity.ok(
                    new ResponseDTO(HttpStatus.OK,"Course deleted!",null)
            );
        }
    }

    public ResponseEntity<ResponseDTO> courseDetail(String id){
        if(courseDAO.existsById(id)){
            return ResponseEntity.ok(
                    new ResponseDTO(HttpStatus.OK,"Retrieved data",courseDAO.findById(id))
            );
        }
        else{
            return ResponseEntity.badRequest().body(
                    new ResponseDTO(HttpStatus.BAD_REQUEST,"Id does not exists",null)
            );
        }
    }

}
