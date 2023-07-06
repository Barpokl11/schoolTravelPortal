package com.schooltravelportal.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorDto {

    private String message;
    private Integer status;
    private String path;
    private LocalDateTime timestamp;
}
