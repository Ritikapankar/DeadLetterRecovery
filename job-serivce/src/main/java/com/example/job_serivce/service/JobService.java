package com.example.job_serivce.service;

import java.util.List;
import java.util.UUID;

import com.example.job_serivce.dto.CreateJobRequest;
import com.example.job_serivce.dto.JobResponse;
import com.example.job_serivce.entity.JobStatus;

public interface JobService {

    JobResponse createJob(CreateJobRequest request);

    List<JobResponse> getAllJobs();

    JobResponse getJobById(UUID id);

    List<JobResponse> getJobsByStatus(JobStatus status);

    JobResponse updateJobStatus(UUID id, JobStatus status);

    void deleteJob(UUID id);

    void retryJob(UUID id, String failureReason);
}
