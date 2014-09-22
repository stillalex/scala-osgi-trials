=================
Scala OSGi Trials
=================

Different tests with Scala and OSGi on Apache Felix

Getting Started
---------------

Here you'll find some info how you can build a running Apache Felix system 
with all the basics you need for Scala.

First download an [Apache Felix distribution](https://felix.apache.org/downloads.cgi), 
for this we're currently using _4.6.0_, [unzip and run](https://felix.apache.org/documentation/subprojects/apache-felix-framework/apache-felix-framework-usage-documentation.html):

    cd felix-framework-4.6.0; java -jar bin/felix.jar

Now you'll be looking at the Gogo shell (_g!_), this will allow us to bootstrap a simple OSGi container with the bundles we're interested in.

I'm now going to install everything needed to get an HTTP Container and the [WebConsole](https://felix.apache.org/documentation/subprojects/apache-felix-web-console.html) running.


```bash

# config-admin
start file:bundles/org.apache.felix.configadmin-1.8.0.jar

# event admin
start file:bundles/org.apache.felix.eventadmin-1.4.2.jar

# logs
start file:bundles/org.apache.sling.commons.log-4.0.0.jar
start file:bundles/slf4j-api-1.7.7.jar
start file:bundles/org.apache.sling.commons.logservice-1.0.2.jar
start file:bundles/log4j-over-slf4j-1.7.7.jar
start file:bundles/jcl-over-slf4j-1.7.7.jar

# http service
start file:bundles/org.apache.felix.http.servlet-api-1.1.0.jar
start file:bundles/org.apache.felix.http.api-2.3.2.jar
start file:bundles/org.apache.felix.http.jetty-3.0.0.jar
start file:bundles/org.apache.felix.http.whiteboard-2.3.2.jar

# webconsole
start file:bundles/commons-io-2.4.jar
start file:bundles/commons-fileupload-1.3.1.jar
start file:bundles/json-20090211_1.jar
start file:bundles/org.apache.felix.webconsole-4.2.6.jar

# scr+metatype
start file:bundles/org.apache.felix.metatype-1.0.10.jar
start file:bundles/org.apache.felix.scr-1.8.2.jar

# event admin plugin
start file:bundles/org.apache.felix.webconsole.plugins.event-1.1.2.jar

# sling installer: bundle & property auto-install under '/install' folder
start file:bundles/org.apache.sling.installer.core-3.6.2.jar
start file:bundles/org.apache.sling.installer.factory.configuration-1.1.2.jar
start file:bundles/org.apache.sling.installer.provider.file-1.0.4.jar
start file:bundles/org.apache.sling.launchpad.installer-1.2.2.jar
start file:bundles/org.apache.sling.settings-1.3.4.jar

# scala
start file:bundles/scala/scala-library-2.11.5.jar

```

Sub-projects
------------

  - [tiny-filter](/tiny-filter) an example of an http filter exposing a basic service built with Scala.
  - [tiny-akka-http](/tiny-akka-http) an example of a basic Akka Http based app.
  - [tiny-akka-http-launcher](/tiny-akka-http-launcher) a demo launchpad for [tiny-akka-http](/tiny-akka-http).
  - [tiny-oak](/tiny-oak) an interesting experiment with [Apache Oak](http://jackrabbit.apache.org/oak).

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

