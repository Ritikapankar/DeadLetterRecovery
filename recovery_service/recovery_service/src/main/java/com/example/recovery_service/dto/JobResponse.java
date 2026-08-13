package com.example.recovery_service.dto;

import java.time.LocalDateTime;
import java.util.UUID;
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
    private String status;
    private String priority;

    private Integer retryCount;
    private Integer maxRetries;
    private String failureReason;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Object getRetryCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRetryCount'");
    }

    
}