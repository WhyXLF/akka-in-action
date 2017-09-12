package com.example.l01;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * author: xiaoliufu
 * date:   2017/9/7.
 * description:
 */
public class AkkaDb extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    private AkkaDb() {
        receive(ReceiveBuilder
                .match(SetRequest.class, message -> {
                    log.info("Received Set request: {}", message);
                })
                .matchAny(o -> log.info("received unknown message: {}", o)).build()
        );


    }
}
