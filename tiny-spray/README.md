==========
Tiny Spray
==========

TODO

  - [spray.httpx] fix OSGi imports for scala.xml in spray.httpx
> Unresolved constraint in bundle io.spray.httpx [41]: Unable to resolve 41.0: missing requirement [41.0] osgi.wiring.package; (&(osgi.wiring.package=scala.xml)(version>=2.11.0)(!(version>=2.12.0)))

  - [spray.routing] it also needs spray.caching, spray.can but marked as optional in sbt
  - [spray.routing] check shapeless dep update to 2.x

Expose ```org.osgi.framework.system.packages.extra=sun.misc``` in conf/config.properties

```bash

start http://search.maven.org/remotecontent?filepath=org/scala-lang/scala-reflect/2.11.0/scala-reflect-2.11.0.jar
start http://search.maven.org/remotecontent?filepath=org/scala-lang/modules/scala-xml_2.11/1.0.1/scala-xml_2.11-1.0.1.jar
start http://search.maven.org/remotecontent?filepath=org/scala-lang/modules/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar

start http://search.maven.org/remotecontent?filepath=com/typesafe/config/1.2.0/config-1.2.0.jar

start http://search.maven.org/remotecontent?filepath=com/typesafe/akka/akka-actor_2.11/2.3.2/akka-actor_2.11-2.3.2.jar
start http://search.maven.org/remotecontent?filepath=com/typesafe/akka/akka-osgi_2.11/2.3.2/akka-osgi_2.11-2.3.2.jar

start http://search.maven.org/remotecontent?filepath=org/parboiled/parboiled-core/1.1.6/parboiled-core-1.1.6.jar
start http://search.maven.org/remotecontent?filepath=org/parboiled/parboiled-scala_2.11/1.1.6/parboiled-scala_2.11-1.1.6.jar

start http://repo.spray.io/io/spray/spray-util_2.11/1.3.1-20140423/spray-util_2.11-1.3.1-20140423.jar
start http://repo.spray.io/io/spray/spray-http_2.11/1.3.1-20140423/spray-http_2.11-1.3.1-20140423.jar
start http://repo.spray.io/io/spray/spray-servlet_2.11/1.3.1-20140423/spray-servlet_2.11-1.3.1-20140423.jar

# needed by spray.httpx
start http://search.maven.org/remotecontent?filepath=org/jvnet/mimepull/mimepull/1.9.4/mimepull-1.9.4.jar

# TODO doesn't currently install, it needs scala.xml >= 2.11.0
start http://repo.spray.io/io/spray/spray-httpx_2.11/1.3.1-20140423/spray-httpx_2.11-1.3.1-20140423.jar

# TODO install shapeless OSGi helper, needed by spray.routing but marked as optional
# start file:/.../scala-osgi-trials/shapeless-helper/target/com.pfalabs.scala-osgi-trials.shapelesshelper_2.11-0.0.1-SNAPSHOT.jar
 
start http://repo.spray.io/io/spray/spray-io_2.11/1.3.1-20140423/spray-io_2.11-1.3.1-20140423.jar
start http://search.maven.org/remotecontent?filepath=com/googlecode/concurrentlinkedhashmap/concurrentlinkedhashmap-lru/1.4/concurrentlinkedhashmap-lru-1.4.jar
start http://repo.spray.io/io/spray/spray-caching_2.11/1.3.1-20140423/spray-caching_2.11-1.3.1-20140423.jar
start http://repo.spray.io/io/spray/spray-can_2.11/1.3.1-20140423/spray-can_2.11-1.3.1-20140423.jar

# TODO doesn't currently install, it needs spray.httpx
# TODO it also needs spray.caching, spray.can but marked as optional in sbt
start http://repo.spray.io/io/spray/spray-routing_2.11/1.3.1-20140423/spray-routing_2.11-1.3.1-20140423.jar

start http://search.maven.org/remotecontent?filepath=org/scalatra/scalate/scalate-util_2.11/1.7.0/scalate-util_2.11-1.7.0.jar
start http://search.maven.org/remotecontent?filepath=org/scalatra/scalate/scalate-core_2.11/1.7.0/scalate-core_2.11-1.7.0.jar

start file:/.../scala-osgi-trials/tiny-spray/target/com.pfalabs.scala-osgi-trials.tinyspray-0.0.1-SNAPSHOT.jar

```
