package com.example.worker_service.service;

import java.util.List;
import com.example.worker_service.client.*;
import org.springframework.stereotype.Service;

import com.example.worker_service.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final JobServiceClient jobServiceClient;

    @Override
    public void processQueuedJobs() {

        log.info("Checking for queued jobs...");

        List<JobResponse> queuedJobs = jobServiceClient.getQueuedJobs();

        if (queuedJobs.isEmpty()) {
            log.info("No queued jobs found.");
            return;
        }

        for (JobResponse job : queuedJobs) {

            try {

                log.info("Processing Job : {}", job.getId());

                // Update status to PROCESSING
                jobServiceClient.markProcessing(job.getId());

                // Simulate resume processing
                Thread.sleep(3000);

                // Processing completed successfully
                jobServiceClient.markCompleted(job.getId());

                log.info("Job {} completed successfully.", job.getId());

            } catch (Exception e) {

                log.error("Job {} failed : {}", job.getId(), e.getMessage());

                // Update status to FAILED
              jobServiceClient.retryJob(job.getId(), e.getMessage());
            }
        }
    }
}