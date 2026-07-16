package com.example.job_serivce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_serivce.dto.CreateJobRequest;
import com.example.job_serivce.dto.JobResponse;
import com.example.job_serivce.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    
    private final JobService jobservice;

    @PostMapping
    public ResponseEntity<JobResponse> createJob(
        @Valid @RequestBody CreateJobRequest request) {
        JobResponse response = jobservice.createJob(request);
       
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
      
    // @GetMapping
    // public ResponseEntity<JobResponse> getAllJob(){

    //     return new ResponseEntity<JobResponse>(jobservice.getAllJobs());
    // }
}
