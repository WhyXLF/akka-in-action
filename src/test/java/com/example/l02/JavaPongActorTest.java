package com.example.l02;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;
import static scala.compat.java8.FutureConverters.*;
/**
 * author: xiaoliufu
 * date:   2017/9/13.
 * description:
 */
public class JavaPongActorTest {
    ActorSystem system = ActorSystem.create();
    ActorRef actorRef = system.actorOf(Props.create(JavaPongActor.class));

    @Test
    public void shouldReplyToPingWithPong() throws Exception{
        Future sFuture = ask(actorRef,"Ping",1000);
        final CompletionStage<String> cs = toJava(sFuture);
        CompletableFuture<String> jFuture = (CompletableFuture<String>) cs;
        assert (jFuture.get(1000, TimeUnit.MILLISECONDS).equals("Pong"));
    }
}