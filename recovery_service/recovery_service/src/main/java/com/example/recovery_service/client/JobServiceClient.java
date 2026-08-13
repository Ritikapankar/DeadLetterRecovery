package com.example.recovery_service.client;

import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recovery_service.dto.JobResponse;

@FeignClient(name ="job-service", url = "http://localhost:8080")
public interface JobServiceClient {
    
@GetMapping("/jobs/status/FAILED")
    List<JobResponse> getFailedJobs();

    @PutMapping("/jobs/{id}/retry")
    void retryJob(@PathVariable UUID id, @RequestParam String failureReason);


}
