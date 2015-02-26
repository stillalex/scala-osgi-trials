==============
Tiny Akka Http
==============

A demo of the [TestServer](https://github.com/akka/akka/blob/akka-stream-and-http-experimental-1.0-M1/akka-http-tests/src/test/scala/akka/http/server/TestServer.scala) that runs on OSGi.

TODO

Expose ```org.osgi.framework.system.packages.extra=sun.misc``` in conf/config.properties

```bash

start file:bundles/scala/scala-library-2.11.4.jar
start file:bundles/scala/scala-reflect-2.11.5.jar
start file:bundles/scala/scala-xml_2.11-1.0.3.jar

start file:bundles/scala/config-1.2.1.jar
start file:bundles/scala/akka-actor_2.11-2.3.9.jar
start file:bundles/scala/akka-slf4j_2.11-2.3.9.jar
start file:bundles/scala/akka-osgi_2.11-2.3.9.jar

start file:bundles/scala/reactive-streams-1.0.0.RC3.jar
start file:bundles/scala/akka-parsing-experimental_2.11-1.0-M3.jar
start file:bundles/scala/akka-stream-experimental_2.11-1.0-M3.jar

# no OSGi headers yet, we'll have to embed for now
# start file:bundles/scala/akka-http-xml-experimental_2.11-1.0-M3.jar
# start file:bundles/scala/akka-http-core-experimental_2.11-1.0-M3.jar
# start file:bundles/scala/akka-http-experimental_2.11-1.0-M3.jar

start file:osgi-trials/tiny-akka-http/target/com.pfalabs.scala-osgi-trials.tinyakkahttp-0.0.1-SNAPSHOT.jar

```
