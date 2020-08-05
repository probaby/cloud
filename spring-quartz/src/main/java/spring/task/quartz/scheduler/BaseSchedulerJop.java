package spring.task.quartz.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author huangbiaof
 * @version V1.0
 * @Description:  调度工具
 * @date 2019/7/31.
 */
public interface BaseSchedulerJop extends Job {
    void execute(JobExecutionContext context)
            throws JobExecutionException;
}
