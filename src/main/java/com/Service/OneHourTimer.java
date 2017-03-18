package com.Service;

import org.springframework.stereotype.Component;

/**
 * Created by Georgi on 25.02.2017.
 */


@Component
public class OneHourTimer {

    public OneHourTimer() {
        Runnable r = new Runnable() {
            public void run() {
                while(true) {
                    System.out.println(1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }
}
