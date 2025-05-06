package com.gevernova;

import static java.lang.Thread.sleep;

public class TaskManager {
    public static String longRunningTask(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "completed";
    }
}
