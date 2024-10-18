package com.postgresql.learnhub.DTO;

import com.postgresql.learnhub.model.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private String name;
    private String mailId;
    private List<Courses> courses;
}
