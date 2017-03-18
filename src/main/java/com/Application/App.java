package com.Application;

import com.Boss.Launcher;

import java.util.Timer;

public class App {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new Launcher(),0,60000);
    }
}
