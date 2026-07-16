package com.example.job_serivce.dto;

import lombok.Data;

import com.example.job_serivce.entity.Priority;

@Data
public class CreateJobRequest {
    @NotBlank(message = "Job type is required")
    private String jobType;

    @NotBlank(message = "Payload is required")
    private String payload;

    private Priority priority;
}   
