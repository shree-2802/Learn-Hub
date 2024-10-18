package com.postgresql.learnhub.controller;


import com.postgresql.learnhub.DTO.LoginDTO;
import com.postgresql.learnhub.DTO.ResponseDTO;
import com.postgresql.learnhub.model.Students;
import com.postgresql.learnhub.services.StudentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("learnapp/api/student/")
@CrossOrigin
public class StudentController{
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices){
        this.studentServices=studentServices;
    }

    @PostMapping("login")
    public ResponseEntity<ResponseDTO> signIn(@RequestBody LoginDTO login){
        return studentServices.loginCheck(login);
    }

    @PostMapping("signup")
    public ResponseEntity<ResponseDTO> signUp(@RequestBody Students student){
        return studentServices.signUp(student);
    }
}