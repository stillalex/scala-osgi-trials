=========
Tiny Oak
=========

Build with Scala ```2.11.x``` and [Oak](https://jackrabbit.apache.org/oak/) ```1.3.x```

[![Oak 1.3.5](https://img.shields.io/badge/Oak-1.3.5-green.svg)](https://jackrabbit.apache.org/oak)
[![soak 0.0.5](https://img.shields.io/badge/soak-0.0.5-blue.svg)](https://github.com/alexparvulescu/soak)
[![License](http://img.shields.io/:license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)

Setup Oak bundles
-----------------

```bash

# sling scheduler
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.commons.threads/3.2.0/org.apache.sling.commons.threads-3.2.0.jar
start http://repo2.maven.org/maven2/org/apache/aries/org.apache.aries.util/1.1.0/org.apache.aries.util-1.1.0.jar
start http://repo2.maven.org/maven2/org/apache/aries/transaction/org.apache.aries.transaction.manager/1.1.0/org.apache.aries.transaction.manager-1.1.0.jar
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.commons.scheduler/2.4.8/org.apache.sling.commons.scheduler-2.4.8.jar

# Oak
start http://repo2.maven.org/maven2/javax/jcr/jcr/2.0/jcr-2.0.jar
start http://repo2.maven.org/maven2/org/apache/jackrabbit/jackrabbit-api/2.11.0/jackrabbit-api-2.11.0.jar
start http://repo2.maven.org/maven2/org/apache/jackrabbit/jackrabbit-jcr-commons/2.11.0/jackrabbit-jcr-commons-2.11.0.jar
start http://repo2.maven.org/maven2/com/google/guava/guava/15.0/guava-15.0.jar
start http://repo2.maven.org/maven2/commons-codec/commons-codec/1.5/commons-codec-1.5.jar
start http://repo2.maven.org/maven2/commons-io/commons-io/2.4/commons-io-2.4.jar

start http://repo2.maven.org/maven2/org/apache/jackrabbit/oak-commons/1.3.5/oak-commons-1.3.5.jar
start http://repo2.maven.org/maven2/org/apache/jackrabbit/oak-blob/1.3.5/oak-blob-1.3.5.jar
start http://repo2.maven.org/maven2/org/apache/jackrabbit/oak-core/1.3.5/oak-core-1.3.5.jar

# start http://repo2.maven.org/maven2/org/apache/tika/tika-core/1.5/tika-core-1.5.jar
# start http://repo2.maven.org/maven2/org/apache/jackrabbit/oak-lucene/1.3.4/oak-lucene-1.3.4.jar

# Jaas Auth
start http://repo2.maven.org/maven2/org/apache/felix/org.apache.felix.jaas/0.0.2/org.apache.felix.jaas-0.0.2.jar

# sling installer: bundle & property auto-install under '/install' folder
# (first create the conf/system.properties file with the following entry 'sling.fileinstall.dir=install')
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.installer.core/3.6.6/org.apache.sling.installer.core-3.6.6.jar
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.installer.factory.configuration/1.1.2/org.apache.sling.installer.factory.configuration-1.1.2.jar
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.launchpad.api/1.2.0/org.apache.sling.launchpad.api-1.2.0.jar
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.settings/1.3.6/org.apache.sling.settings-1.3.6.jar
# org.apache.sling.installer.provider.file-1.1.0 is broken, see SLING-4478
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.installer.provider.file/1.0.4/org.apache.sling.installer.provider.file-1.0.4.jar
start http://repo2.maven.org/maven2/org/apache/sling/org.apache.sling.launchpad.installer/1.2.2/org.apache.sling.launchpad.installer-1.2.2.jar

start https://bintray.com/artifact/download/pfalabs/maven/com/pfalabs/com.pfalabs.soak_2.11/0.0.5/com.pfalabs.soak_2.11-0.0.5.jar

```

Install oak example
-------------------

```bash

# [bash] Install Example config files 
cp src/main/config/*.config felix/install

# [bash] Install Example bundle
cp target/com.pfalabs.scala-osgi-trials.tinyoak-*.jar felix/install
```

Launchpad version
-----------------

A simple demo launchpad for this example is available at [tiny-oak-launcher](/tiny-oak-launcher).
