package com.aerospace;

import com.aerospace.service.sip.ILSConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
//@EnableEurekaClient
//@EnableConfigurationProperties(ILSConfiguration.class)
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();


        //print(universityCareerFair([1, 3, 3, 5, 7], [2, 2, 1, 2, 1])) # 4
        //print(universityCareerFair([1, 2], [7, 3])) # 1
        //print(universityCareerFair([1, 3, 4, 6], [4, 3, 3, 2])) # 2

        //List<Integer> arrival = Arrays.asList(1, 3, 3, 5, 7);
        //List<Integer> duration = Arrays.asList(2, 2, 1, 2, 1);

        List<Integer> arrival = Arrays.asList(1,2);
        List<Integer> duration = Arrays.asList(7,3);

        System.out.println( maxEvents(arrival, duration));

    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        //Maximum time
        int event = 1;
        int maxTime = arrival.get(0) + duration.get(0);
        for(int i = 1 ; i < arrival.size(); i++) {
            if(arrival.get(i) >= maxTime) {
                maxTime = arrival.get(i) + duration.get(i);
                event++;
            }
        }

        return event++;

    }

}
