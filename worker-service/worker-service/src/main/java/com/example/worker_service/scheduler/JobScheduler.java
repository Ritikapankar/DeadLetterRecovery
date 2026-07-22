package main.java.com.example.worker_service.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.deadletter.workerservice.service.WorkerService;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class JobScheduler {
    private final WorkerService workerService;

    @Scheduled(fixedDelay = 5000)
    public void pollJobs() {

        workerService.processQueuedJobs();

    }
}
