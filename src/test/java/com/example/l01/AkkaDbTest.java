package com.example.l01;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author: xiaoliufu
 * date:   2017/9/12.
 * description:
 */
public class AkkaDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShoudPlaceKeyValueFromSetMessageIntoMap(){
        TestActorRef<AkkaDb> actorRef = TestActorRef.create(system, Props.create(AkkaDb.class));
        actorRef.tell(new SetRequest("key","value"), ActorRef.noSender());

        AkkaDb akkaDb = actorRef.underlyingActor();
        assertEquals(akkaDb.map.get("key"),"value");
    }
}