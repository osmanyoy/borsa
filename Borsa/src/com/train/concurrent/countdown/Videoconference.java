package com.train.concurrent.countdown;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(final int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(final String name) {
        System.out.printf("%s has arrived.\n",
                          name);
        this.controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",
                          this.controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n\n",
                          this.controller.getCount());

        try {
            this.controller.await();

            System.out.printf("\r\nVideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
