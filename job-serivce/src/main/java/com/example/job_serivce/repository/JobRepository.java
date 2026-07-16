package com.example.job_serivce.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job_serivce.entity.Job;

public interface JobRepository  extends JpaRepository<Job, UUID> {
   
    
} 
