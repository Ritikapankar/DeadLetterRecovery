package com.example.job_serivce.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.job_serivce.dto.CreateJobRequest;
import com.example.job_serivce.dto.JobResponse;
import com.example.job_serivce.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    // Create Job
    @PostMapping
    public ResponseEntity<JobResponse> createJob(
            @RequestBody CreateJobRequest request) {

        JobResponse response = jobService.createJob(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Jobs
    @GetMapping
    public ResponseEntity<List<JobResponse>> getAllJobs() {

        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // Get Job By Id
    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJobById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(jobService.getJobById(id));
    }

    // Delete Job
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(
            @PathVariable UUID id) {

        jobService.deleteJob(id);

        return ResponseEntity.ok("Job deleted successfully.");
    }
}