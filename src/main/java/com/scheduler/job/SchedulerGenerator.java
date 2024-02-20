package com.scheduler.job;

import com.scheduler.service.ReportService;
import com.scheduler.service.SenderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class SchedulerGenerator {

    private final ReportService reportService;

    private final SenderService notificationService;

//    @Scheduled(cron = "0 */2 * * * *")
    public void generateReportAndSendEmail() {
        log.info("Execution started on {} ", new Date());
        try {
            byte[] reportContent = reportService.generateReport();
            notificationService.sendDailyReports(reportContent);
            log.info("Execution ended on {} ", new Date());

        } catch (IOException | MessagingException e) {
            log.error("Exception occurred {} ", e.getMessage());
            e.printStackTrace();
        }
    }
}
