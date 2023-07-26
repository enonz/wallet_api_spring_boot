package com.example.walletapi.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Top5Stocks {
    @Scheduled(cron = "0 * 9 * * ?", fixedDelay = 5000)
    public void proceed() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Schedule to get top 5 stocks" + strDate);
    }
}
