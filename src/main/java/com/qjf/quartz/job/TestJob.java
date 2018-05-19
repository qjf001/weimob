package com.qjf.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Timestamp;

/**
 * @Author:Tin
 * @Date: create in 2018/3/16 16:17
 * @Description:
 */
public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("执行了："+new Timestamp(System.currentTimeMillis()));

    }
}
