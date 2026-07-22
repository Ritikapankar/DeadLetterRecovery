package main.java.com.example.worker_service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class JobResponse {

    private UUID id;

    private String jobType;

    private String payload;

    private String status;

    private String priority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

