package com.example.l02.provider;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.example.l01.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * author: xiaoliufu
 * date:   2017/9/16.
 * description:
 */
public class AkkaDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    public AkkaDb() {
        receive(ReceiveBuilder
                .match(SetRequest.class, message -> {
                    log.info("Received Set request:{}", message);
                    map.put(message.getKey(), message.getValue());
                    sender().tell(new Status.Success(message.getKey()), self());
                })
                .match(GetRequest.class, message -> {
                    log.info("Received Get request:{}", message);
                    Object value = map.get(message.key);
                    Object response = (value != null) ? value : new Status.Failure(new KeyNotFoundException(message.key));
                    sender().tell(response, self());
                })
                .matchAny(o -> {
                    sender().tell(new Status.Failure(new ClassNotFoundException()), self());
                })
                .build());
    }
}
