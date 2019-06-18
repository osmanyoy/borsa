package com.train.concurrent.countdown;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

    private final Videoconference conference;

    private final String name;

    public Participant(final Videoconference conference,
                       final String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        Long duration = (long) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.conference.arrive(this.name);
    }

}
