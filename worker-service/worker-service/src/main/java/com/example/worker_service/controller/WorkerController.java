package main.java.com.example.worker_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deadletter.workerservice.service.WorkerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping("/run")
    public ResponseEntity<String> runWorker() {

        workerService.processQueuedJobs();

        return ResponseEntity.ok("Worker executed successfully.");

    }

}