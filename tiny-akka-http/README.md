==============
Tiny Akka Http
==============

A demo of the [TestServer](https://github.com/akka/akka/blob/releasing-akka-stream-and-http-experimental-1.0/akka-http-tests/src/test/scala/akka/http/scaladsl/server/TestServer.scala) that runs on OSGi powered by the akka reactive-streams 1.0 impl.

Last update: July 17th 2015.

TODO

Expose ```org.osgi.framework.system.packages.extra=sun.misc``` in conf/config.properties

```bash

start http://repo2.maven.org/maven2/org/scala-lang/scala-library/2.11.7/scala-library-2.11.7.jar
start http://repo2.maven.org/maven2/org/scala-lang/scala-reflect/2.11.7/scala-reflect-2.11.7.jar
start http://repo2.maven.org/maven2/org/scala-lang/modules/scala-xml_2.11/1.0.4/scala-xml_2.11-1.0.4.jar

start http://repo2.maven.org/maven2/com/typesafe/config/1.2.1/config-1.2.1.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-actor_2.11/2.3.12/akka-actor_2.11-2.3.12.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-slf4j_2.11/2.3.12/akka-slf4j_2.11-2.3.12.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-osgi_2.11/2.3.12/akka-osgi_2.11-2.3.12.jar

start http://repo2.maven.org/maven2/org/reactivestreams/reactive-streams/1.0.0/reactive-streams-1.0.0.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-parsing-experimental_2.11/1.0/akka-parsing-experimental_2.11-1.0.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-stream-experimental_2.11/1.0/akka-stream-experimental_2.11-1.0.jar

start http://repo2.maven.org/maven2/com/typesafe/akka/akka-http-core-experimental_2.11/1.0/akka-http-core-experimental_2.11-1.0.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-http-experimental_2.11/1.0/akka-http-experimental_2.11-1.0.jar
start http://repo2.maven.org/maven2/com/typesafe/akka/akka-http-xml-experimental_2.11/1.0/akka-http-xml-experimental_2.11-1.0.jar

# build this project and install it
start file:osgi-trials/tiny-akka-http/target/com.pfalabs.scala-osgi-trials.tinyakkahttp-0.0.1-SNAPSHOT.jar

```

Check out the [Tiny Akka Http Launcher](/tiny-akka-http-launcher) for a fully packaged version.

