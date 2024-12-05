package org.annotationConfig;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeService {

//    private String timeService;

//    public TimeService(String timeService) {
//        this.timeService = timeService;
//    }

    public String getTimeService() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }





}
