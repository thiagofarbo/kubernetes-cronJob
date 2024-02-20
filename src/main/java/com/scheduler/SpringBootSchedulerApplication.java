package com.scheduler;

import com.scheduler.job.SchedulerGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulerApplication  {

    @Autowired
    private SchedulerGenerator scheduler;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSchedulerApplication.class, args);
    }


    @Bean
    public String run() {
        scheduler.generateReportAndSendEmail();
        return "Job Started...";
    }
}
