package com.my.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {


    //每隔5秒钟触发一次
    @Scheduled(cron = "0/5 * * * * * ")
    public void work() {
        System.out.println("执行了任务work");
    }

    //15:58：30触发
    @Scheduled(cron = "30 58 15 * * * ")
    public void work1() {
        System.out.println("执行了任务work");
    }

    //固定时间间隔
    @Scheduled(fixedDelay = 1000 * 5)
    public void work2() {
        System.out.println("执行了任务work2");
    }

    //固定频率任务
    @Scheduled(fixedRate = 1000 * 5)
    public void work3() {
        System.out.println("执行了任务work3");
    }

}
