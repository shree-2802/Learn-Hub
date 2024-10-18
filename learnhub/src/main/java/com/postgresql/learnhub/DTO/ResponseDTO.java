package com.postgresql.learnhub.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private HttpStatus status;
    private String message;
    private Object data;
}
