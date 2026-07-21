package com.example.job_serivce.dto;

import com.example.job_serivce.entity.Priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobRequest {

    private String jobType;

    private String payload;

    private Priority priority;
}