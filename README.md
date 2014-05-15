=================
Scala OSGi Trials
=================

Different tests with Scala and OSGi on Apache Felix

Getting Started
---------------

Here you'll find some info how you can build a running Apache Felix system 
with all the basics you need for Scala.

First download an [Apache Felix distribution](https://felix.apache.org/downloads.cgi), 
for this we're currently using _4.4.0_, [unzip and run](https://felix.apache.org/documentation/subprojects/apache-felix-framework/apache-felix-framework-usage-documentation.html):

    cd felix-framework-4.4.0; java -jar bin/felix.jar

Now you'll be looking at the Gogo shell (_g!_), this will allow us to bootstrap a simple OSGi container with the bundles we're interested in.

I'm now going to install everything needed to get an HTTP Container and the [WebConsole](https://felix.apache.org/documentation/subprojects/apache-felix-web-console.html) running.


```bash
# file-install (for good measure)
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.fileinstall/3.2.8/org.apache.felix.fileinstall-3.2.8.jar

# config-admin
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.configadmin/1.8.0/org.apache.felix.configadmin-1.8.0.jar

# event admin
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.eventadmin/1.3.2/org.apache.felix.eventadmin-1.3.2.jar

# logs
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.commons.logservice/1.0.2/org.apache.sling.commons.logservice-1.0.2.jar
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.commons.log/3.0.2/org.apache.sling.commons.log-3.0.2.jar
start http://search.maven.org/remotecontent?filepath=org/slf4j/slf4j-api/1.6.4/slf4j-api-1.6.4.jar

# http service 

# (this you'll have to build for yourself at the moment)
# svn co https://svn.apache.org/repos/asf/felix/trunk/http felix-http
# cd felix-http; mvn clean install; cd ../

start file:../felix-http/servlet-api/target/org.apache.felix.http.servlet-api-0.0.1-SNAPSHOT.jar
start file:../felix-http/api/target/org.apache.felix.http.api-2.3.0-SNAPSHOT.jar
start file:../felix-http/jetty/target/org.apache.felix.http.jetty-2.3.0-SNAPSHOT.jar
start file:../felix-http/whiteboard/target/org.apache.felix.http.whiteboard-2.3.0-SNAPSHOT.jar

# webconsole
start http://search.maven.org/remotecontent?filepath=commons-io/commons-io/2.4/commons-io-2.4.jar
start http://search.maven.org/remotecontent?filepath=commons-fileupload/commons-fileupload/1.3.1/commons-fileupload-1.3.1.jar
start http://search.maven.org/remotecontent?filepath=org/apache/geronimo/bundles/json/20090211_1/json-20090211_1.jar
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.webconsole/4.2.2/org.apache.felix.webconsole-4.2.2.jar
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.webconsole.plugins.event/1.1.0/org.apache.felix.webconsole.plugins.event-1.1.0.jar

# scr+metatype
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.metatype/1.0.10/org.apache.felix.metatype-1.0.10.jar
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.scr/1.8.2/org.apache.felix.scr-1.8.2.jar

# scala
start http://search.maven.org/remotecontent?filepath=org/scala-lang/scala-library/2.11.0/scala-library-2.11.0.jar

```

Sub-projects
------------

  - [tiny-filter](/tiny-filter) an example of an http filter exposing a basic service built with Scala.
  - [tiny-spray](/tiny-spray) an example of a basic Spray based app.

License
-------

(see [LICENSE.txt](LICENSE.txt) for full license details)

Copyright 2014 Alex Parvulescu.

Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

