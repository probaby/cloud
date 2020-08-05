package spring.task.quartz.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangbiaof
 * @version V1.0
 * @Description:  测试
 * @date 2019/7/31.
 */
@Component
public class TestJob implements BaseSchedulerJop{
    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.error("--------------TEST每5秒输出一次---------------------");
    }
}
