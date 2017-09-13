package com.practise.l01;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xiaoliufu
 * date:   2017/9/12.
 * description:
 */
public class SenderActor extends AbstractActor{
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);
    private static final List<String> customList = new ArrayList<>();
    public SenderActor() {
        receive(ReceiveBuilder.match(String.class,msg ->{
            log.info("Send message msg={}",msg);
            customList.add(msg);
        }).build());
    }
}
