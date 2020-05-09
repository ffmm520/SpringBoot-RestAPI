package club.mrhu.startspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Date;

@EnableScheduling  // 启用定时
@EnableAsync  // 启用多线程
@SpringBootApplication
public class StartSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartSpringbootApplication.class, args);
    }


    // 开启多线程
    @Async
    @Scheduled(fixedRate = 5 * 1000)
    public void doSth1() {
        System.out.println("hello job " + DateFormat.getDateInstance().format(new Date()));
    }

}
