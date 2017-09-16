name := """akka-in-action"""
organization := "com.xlf.akka-in-action"
version := "0.0.1-SNAPSHOT"
version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(

  // Uncomment to use Akka
  //"com.typesafe.akka" % "akka-actor_2.11" % "2.3.9",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.5.0",
  "com.typesafe.akka" %% "akka-actor" % "2.3.6" ,
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"

)
mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}
