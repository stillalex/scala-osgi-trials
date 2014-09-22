==========
Tiny Oak
==========


```bash

# sling scheduler
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.commons.threads/3.2.0/org.apache.sling.commons.threads-3.2.0.jar
start http://search.maven.org/remotecontent?filepath=org/apache/aries/org.apache.aries.util/1.1.0/org.apache.aries.util-1.1.0.jar
start http://search.maven.org/remotecontent?filepath=org/apache/aries/transaction/org.apache.aries.transaction.manager/1.1.0/org.apache.aries.transaction.manager-1.1.0.jar
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.commons.scheduler/2.4.4/org.apache.sling.commons.scheduler-2.4.4.jar

# Oak

start http://search.maven.org/remotecontent?filepath=com/google/guava/guava/15.0/guava-15.0.jar

start http://search.maven.org/remotecontent?filepath=javax/jcr/jcr/2.0/jcr-2.0.jar
start http://search.maven.org/remotecontent?filepath=commons-codec/commons-codec/1.5/commons-codec-1.5.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/jackrabbit-api/2.9.0/jackrabbit-api-2.9.0.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/jackrabbit-jcr-commons/2.9.0/jackrabbit-jcr-commons-2.9.0.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/oak-commons/1.0.5/oak-commons-1.0.5.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/oak-mk-api/1.0.5/oak-mk-api-1.0.5.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/oak-blob/1.0.5/oak-blob-1.0.5.jar
start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/oak-core/1.0.5/oak-core-1.0.5.jar

# start http://search.maven.org/remotecontent?filepath=org/apache/tika/tika-core/1.5/tika-core-1.5.jar
# start https://repository.apache.org/service/local/repositories/releases/content/org/apache/jackrabbit/oak-lucene/1.0.5/oak-lucene-1.0.5.jar

# Jaas Auth
start http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.jaas/0.0.2/org.apache.felix.jaas-0.0.2.jar

# Sling file installer (first create the conf/system.properties file with the following entry 'sling.fileinstall.dir=install')
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.installer.core/3.5.4/org.apache.sling.installer.core-3.5.4.jar
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.installer.console/1.0.0/org.apache.sling.installer.console-1.0.0.jar
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.installer.factory.configuration/1.0.14/org.apache.sling.installer.factory.configuration-1.0.14.jar
start http://search.maven.org/remotecontent?filepath=org/apache/sling/org.apache.sling.installer.provider.file/1.0.4/org.apache.sling.installer.provider.file-1.0.4.jar

# Install Scala Oak bundle
start https://github.com/alexparvulescu/soak/releases/download/0.0.2/com.pfalabs.soak-0.0.2.jar

# Install Example config files (bash)
cp src/main/config/*.config felix/install

# Install Example bundle (bash)
cp target/com.pfalabs.scala-osgi-trials.tinyoak-0.0.1-SNAPSHOT.jar felix/install

```
