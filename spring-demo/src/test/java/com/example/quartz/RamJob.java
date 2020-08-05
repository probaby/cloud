package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author huangbiaof
 * @data 创建时间：2019/6/27 11:07
 */

class RamJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Say hello to Quartz" + new Date());
    }
}
