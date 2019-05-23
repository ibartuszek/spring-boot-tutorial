package com.example.productapp.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private final Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Scheduled(cron = "0 * 9 * * ?")
    public void doCronJob() {
        logDateNow("Java cron job expression:: ");
    }

    @Scheduled(fixedRate = 1000)
    public void doFixedRateJob() {
        logDateNow("Fixed Rate scheduler:: ");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void doFixedDelayedJob() {
        logDateNow("Fixed Delay scheduler:: ");
    }

    private void logDateNow(final String message) {
        Date now = new Date();
        logger.info(message + simpleDateFormat.format(now));
    }

}
