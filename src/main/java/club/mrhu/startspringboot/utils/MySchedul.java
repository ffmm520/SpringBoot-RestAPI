package club.mrhu.startspringboot.utils;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Date;

@EnableScheduling
public class MySchedul {

    @Scheduled(fixedRate = 10 * 1000)
    public void doSth1() {
        System.out.println("hello job" + DateFormat.getDateInstance().format(new Date()));
    }
}
