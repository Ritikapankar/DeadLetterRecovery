package com.example.worker_service.service;

import org.springframework.stereotype.Service;

@Service
public interface WorkerService {

    void processQueuedJobs();


}


