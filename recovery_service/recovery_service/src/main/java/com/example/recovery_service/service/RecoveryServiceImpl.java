package com.example.recovery_service.service;

import org.springframework.stereotype.Service;

import com.example.recovery_service.client.JobServiceClient;
import com.example.recovery_service.dto.JobResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecoveryServiceImpl implements RecoveryService {
    
private final JobServiceClient jobServiceClient;


    @Override
    public void recoverFailedJobs() {
        List<JobResponse> failedJobs = jobServiceClient.getFailedJobs();
        for (JobResponse job : failedJobs) {
           log.info("Recovering job: {}",
            job.getRetryCount(),
        job.getMaxRetries()
    );
             try{
                jobServiceClient.retryJob(job.getId(), "Retrying failed job");
                log.info("Job {} retried successfully.", job.getId());
            } catch (Exception e) {
                log.error("Failed to retry job {}: {}", job.getId(), e.getMessage());
             }
            
        }
    }
}
