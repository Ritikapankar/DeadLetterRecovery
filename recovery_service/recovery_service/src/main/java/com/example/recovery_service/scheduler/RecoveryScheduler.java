package com.example.recovery_service.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.recovery_service.service.RecoveryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecoveryScheduler {

    private final RecoveryService recoveryService;

    @Scheduled(fixedDelay = 10000)
    public void recoverJobs() {

        log.info("Recovery scheduler started...");

        recoveryService.recoverFailedJobs();
    }
}
