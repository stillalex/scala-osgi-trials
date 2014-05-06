==========
Tiny Spray
==========

Expose ```osgi.wiring.package=sun.misc``` in conf/config.properties

```bash

start http://search.maven.org/remotecontent?filepath=org/scala-lang/scala-reflect/2.10.4/scala-reflect-2.10.4.jar

start http://search.maven.org/remotecontent?filepath=com/typesafe/config/1.2.0/config-1.2.0.jar

start http://search.maven.org/remotecontent?filepath=com/typesafe/akka/akka-osgi_2.10/2.3.2/akka-osgi_2.10-2.3.2.jar
start http://search.maven.org/remotecontent?filepath=com/typesafe/akka/akka-actor_2.10/2.3.2/akka-actor_2.10-2.3.2.jar

start http://search.maven.org/remotecontent?filepath=org/parboiled/parboiled-core/1.1.6/parboiled-core-1.1.6.jar
start http://search.maven.org/remotecontent?filepath=org/parboiled/parboiled-scala_2.10/1.1.6/parboiled-scala_2.10-1.1.6.jar

start http://search.maven.org/remotecontent?filepath=io/spray/spray-util/1.3.1/spray-util-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-http/1.3.1/spray-http-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-servlet/1.3.1/spray-servlet-1.3.1.jar

start http://search.maven.org/remotecontent?filepath=org/jvnet/mimepull/mimepull/1.9.4/mimepull-1.9.4.jar

# TODO install shapeless OSGi helper
# start file:/.../scala-osgi-trials/shapeless-helper/target/com.pfalabs.scala-osgi-trials.shapelesshelper-0.0.1-SNAPSHOT.jar

start http://search.maven.org/remotecontent?filepath=io/spray/spray-io/1.3.1/spray-io-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-httpx/1.3.1/spray-httpx-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-routing/1.3.1/spray-routing-1.3.1.jar

start http://search.maven.org/remotecontent?filepath=com/googlecode/concurrentlinkedhashmap/concurrentlinkedhashmap-lru/1.4/concurrentlinkedhashmap-lru-1.4.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-caching/1.3.1/spray-caching-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=io/spray/spray-can/1.3.1/spray-can-1.3.1.jar

start http://search.maven.org/remotecontent?filepath=org/fusesource/scalate/scalate-util_2.10/1.6.1/scalate-util_2.10-1.6.1.jar
start http://search.maven.org/remotecontent?filepath=org/fusesource/scalate/scalate-core_2.10/1.6.1/scalate-core_2.10-1.6.1.jar

start file:/.../scala-osgi-trials/tiny-spray/target/com.pfalabs.scala-osgi-trials.tinyspray-0.0.1-SNAPSHOT.jar

```
