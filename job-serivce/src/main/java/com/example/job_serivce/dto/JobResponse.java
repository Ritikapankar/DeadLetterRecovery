package com.example.job_serivce.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.job_serivce.entity.JobStatus;
import com.example.job_serivce.entity.Priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {

    private UUID id;

    private String jobType;

    private String payload;

    private JobStatus status;

    private Priority priority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}