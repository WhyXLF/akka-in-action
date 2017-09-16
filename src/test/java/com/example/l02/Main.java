package com.example.l02;

import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * author: xiaoliufu
 * date:   2017/9/16.
 * description:
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("akka");
        system.actorOf(Props.create(AkkaDb.class), "akka-db");
    }
}
