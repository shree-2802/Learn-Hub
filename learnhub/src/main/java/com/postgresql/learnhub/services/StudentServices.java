package com.postgresql.learnhub.services;

import com.postgresql.learnhub.DAO.StudentDAO;
import com.postgresql.learnhub.DTO.LoginDTO;
import com.postgresql.learnhub.DTO.LoginResponseDTO;
import com.postgresql.learnhub.DTO.ResponseDTO;
import com.postgresql.learnhub.model.Courses;
import com.postgresql.learnhub.model.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    private final StudentDAO studentDAO;

    public StudentServices(StudentDAO studentDAO){
        this.studentDAO=studentDAO;
    }

    public ResponseEntity<ResponseDTO> loginCheck(LoginDTO input){
        boolean isUser=studentDAO.existsByMailIdAndPassword(input.getMailId(),input.getPassword());
        if(isUser){
            Students student=studentDAO.findByMailId(input.getMailId());
            var data= LoginResponseDTO.builder()
                    .name(student.getName())
                    .mailId(student.getMailId())
                    .courses(student.getCourses())
                    .build();

            return ResponseEntity.ok(new ResponseDTO(HttpStatus.OK,"Logged in successfully",data));
        }
        else{
            return ResponseEntity.badRequest().body(new ResponseDTO(HttpStatus.FORBIDDEN, "Invalid mail Id, Not an user!",null));
        }
    }

    public ResponseEntity<ResponseDTO> signUp(Students input){
        if(input.getMailId()!=null || studentDAO.existsByMailId(input.getMailId())){
            return ResponseEntity.badRequest().body(new ResponseDTO(HttpStatus.BAD_REQUEST,"Already an existing user",null));
        }
        else{
            studentDAO.save(input);
            return ResponseEntity.ok(new ResponseDTO(HttpStatus.OK,"Signed Up Successfully",null));
        }
    }
}
