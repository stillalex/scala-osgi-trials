=======================
Tiny Akka Http Launcher
=======================

A simple demo launchpad for [tiny-akka-http](/tiny-akka-http). Just build the 2 project and you get a runnable jar 
that contains the entire package.

```bash

# first install tiny-akka-http
cd ../tiny-akka-http; mvn install; cd ../tiny-akka-http-launcher; mvn package

# run & enjoy
java -jar target/com.pfalabs.scala-osgi-trials.tinyakkahttp-launcher-0.0.1-SNAPSHOT.jar

```

Navigate to [localhost:8080](http://localhost:8080)



