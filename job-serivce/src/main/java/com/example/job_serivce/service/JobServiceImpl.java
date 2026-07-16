package com.example.job_serivce.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.job_serivce.dto.CreateJobRequest;
import com.example.job_serivce.dto.JobResponse;
import com.example.job_serivce.entity.Job;
import com.example.job_serivce.repository.JobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

 
  private final JobRepository jobRepository;

  @Override
  public JobResponse createJob(CreateJobRequest createJobRequest) {
     Job job = Job.builder()
     .jobType(createJobRequest.getJobType())
     .payload(createJobRequest.getPayload())
     .priority(createJobRequest.getPriority())
     .build();

     Job savedJob = jobRepository.save(job);
     return mapToResponse(savedJob);
  }


  @Override
public List<JobResponse> getAllJobs() {
    List<Job> jobs = jobRepository.findAll();
    return jobs.stream()
            .map(this::mapToResponse)
            .toList();
}

  @Override
  public JobResponse getJobById(UUID jobId) {
    Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
    return mapToResponse(job);
  }

  @Override
  public void deleteJob(UUID jobId) {
    Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
    jobRepository.delete(job);
  }

  private JobResponse mapToResponse(Job job){
    return JobResponse.builder()
    .id(job.getId())
    .jobType(job.getJobType())
    .payload(job.getPayload())
    .status(job.getStatus())
    .priority(job.getPriority())
    .createdAt(job.getCreatedAt())
    .updatedAt(job.getUpdatedAt())
    .build();
    
  }  

}