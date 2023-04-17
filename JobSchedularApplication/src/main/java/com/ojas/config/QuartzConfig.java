package com.ojas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;

@Configuration
public class QuartzConfig {

    private static final int DAILY_HOUR = 20;
    private static final int WEEKLY_HOUR = 20;
    private static final int MONTHLY_HOUR = 20;

    @Bean
    public JobDetail dailyMailerJobDetail() {
        return JobBuilder.newJob(DailyMailerJob.class)
                .withIdentity("dailyMailerJob")
                .build();
    }

    @Bean
    public Trigger dailyMailerJobTrigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .withIdentity("dailyMailerTrigger")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(DAILY_HOUR,
