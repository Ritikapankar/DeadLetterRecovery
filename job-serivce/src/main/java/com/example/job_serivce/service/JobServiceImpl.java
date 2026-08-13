package com.example.job_serivce.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.job_serivce.dto.*;
import com.example.job_serivce.entity.*;
import com.example.job_serivce.exception.*;
import com.example.job_serivce.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobResponse createJob(CreateJobRequest request) {

        Job job = Job.builder()
                .jobType(request.getJobType())
                .payload(request.getPayload())
                .priority(request.getPriority())
                .status(JobStatus.QUEUED)
                .build();

        Job savedJob = jobRepository.save(job);

        return mapToResponse(savedJob);
    }

    @Override
    public List<JobResponse> getAllJobs() {

        return jobRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public JobResponse getJobById(UUID id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id : " + id));

        return mapToResponse(job);
    }

    @Override
    public List<JobResponse> getJobsByStatus(JobStatus status) {

        return jobRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public JobResponse updateJobStatus(UUID id, JobStatus status) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id : " + id));

        job.setStatus(status);
        Job updatedJob = jobRepository.save(job);

        return mapToResponse(updatedJob);
    }

    @Override
    public void deleteJob(UUID id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id : " + id));

        jobRepository.delete(job);
    }

     @override
    public void retryJob(UUID id, String failureReason) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id : " + id));

     job.setRetryCount(job.getRetryCount() + 1);
     job.setFailureReason(failureReason);

     if(job.getRetryCount() >= job.getMaxRetries()) {
         job.setStatus(JobStatus.FAILED);
     } else {
         job.setStatus(JobStatus.QUEUED);
     }
    }

    private JobResponse mapToResponse(Job job) {

        return JobResponse.builder()
                .id(job.getId())
                .jobType(job.getJobType())
                .payload(job.getPayload())
                .status(job.getStatus())
                .priority(job.getPriority())
                .retryCount(job.getRetryCount())
                .maxRetries(job.getMaxRetries())
                .failureReason(job.getFailureReason())
                .createdAt(job.getCreatedAt())
                .updatedAt(job.getUpdatedAt())
                
                .build();
    }
}
