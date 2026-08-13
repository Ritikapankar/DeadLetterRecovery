package com.example.job_serivce.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job_serivce.entity.Job;
import com.example.job_serivce.entity.JobStatus;

public interface JobRepository extends JpaRepository<Job, UUID> {

    List<Job> findByStatus(JobStatus status);

}
