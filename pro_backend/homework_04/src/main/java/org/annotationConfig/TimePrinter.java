package org.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimePrinter {

    private final TimeService time;

    @Autowired
    public TimePrinter(TimeService time) {
        this.time = time;
    }

    public void print(){
        System.out.println(time.getTimeService());
    }
}
