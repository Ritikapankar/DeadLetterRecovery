package com.example.worker_service.scheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.example.worker_service.service.WorkerService;

@Component
@RequiredArgsConstructor
public class JobScheduler {
    private final WorkerService workerService;

    @Scheduled(fixedDelay = 5000)
    public void pollJobs() {

        workerService.processQueuedJobs();

    }
}
