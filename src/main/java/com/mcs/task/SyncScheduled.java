package com.mcs.task;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mcs.service.SyncService;

@Component
public class SyncScheduled
{
    private static final Log log = LogFactory.getLog(SyncScheduled.class);
    
    @Resource
    private SyncService syncService;
    
    /**
     * cron表达式有至少6个（也可能7个）有空格分隔的时间元素。 按顺序依次为 秒（0~59）, 分钟（0~59）, 小时（0~23）, 天（月）（0~31，但是你需要考虑你月的天数）, 月（0~11）, 天（星期）（1~7
     * 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT） ,年份（1970－2099）
     */
    @Scheduled(cron = "0 0 23 * * ? ")
    // 每天23点钟执行一次,前面两个时间参数设置为0,0,则执行一次
    public void runFunction()
        throws Exception
    {
        log.info(new Date() + " scheduled task:每天23点删除同步记录......");
        syncService.removeSync();
    }
    
}
