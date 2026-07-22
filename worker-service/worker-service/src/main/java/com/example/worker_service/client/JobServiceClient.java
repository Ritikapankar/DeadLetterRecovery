package main.java.com.example.worker_service.client;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.deadletter.workerservice.dto.JobResponse;

@FeignClient(
        name = "job-service",
        url = "http://localhost:8081"
)
public interface JobServiceClient {

    @GetMapping("/jobs/status/QUEUED")
    List<JobResponse> getQueuedJobs();

    @PutMapping("/jobs/{id}/status/PROCESSING")
    void markProcessing(@PathVariable UUID id);

    @PutMapping("/jobs/{id}/status/COMPLETED")
    void markCompleted(@PathVariable UUID id);

    @PutMapping("/jobs/{id}/status/FAILED")
    void markFailed(@PathVariable UUID id);

}