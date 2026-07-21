package com.example.job_serivce.service;

import java.util.List;
import java.util.UUID;

import com.example.job_serivce.dto.CreateJobRequest;
import com.example.job_serivce.dto.JobResponse;

public interface JobService {

    JobResponse createJob(CreateJobRequest request);

    List<JobResponse> getAllJobs();

    JobResponse getJobById(UUID id);

    void deleteJob(UUID id);
}