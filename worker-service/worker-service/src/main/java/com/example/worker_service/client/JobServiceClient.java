package com.example.worker_service.client;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.worker_service.dto.JobResponse;

@FeignClient(
        name = "job-service",
        url = "http://localhost:8080"
)
public interface JobServiceClient {

    @GetMapping("/jobs/status/QUEUED")
    List<JobResponse> getQueuedJobs();

    @PutMapping("/jobs/{id}/status/PROCESSING")
    void markProcessing(@PathVariable("id") UUID id);

    @PutMapping("/jobs/{id}/status/COMPLETED")
    void markCompleted(@PathVariable("id") UUID id);

    @PutMapping("/jobs/{id}/status/FAILED")
    void markFailed(@PathVariable("id") UUID id);
 
     @PutMapping("/jobs/{id}/retry")
    void retryJob(@PathVariable("id") UUID id, @RequestParam("failureReason") String failureReason);

}