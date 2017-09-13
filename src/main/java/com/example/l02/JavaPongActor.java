package com.example.l02;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * author: xiaoliufu
 * date:   2017/9/13.
 * description:
 */
public class JavaPongActor extends AbstractActor {
    @Override
    public PartialFunction<Object, BoxedUnit> receive() {
        return ReceiveBuilder.matchEquals("Ping", msg -> sender().tell("ping", ActorRef.noSender())
        ).matchAny(msg -> {
            sender().tell(new Status.Failure(new Exception("Unknown message")), self());
        }).build();
    }
}
