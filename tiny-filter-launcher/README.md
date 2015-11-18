====================
Tiny Filter Launcher
====================

A simple demo launchpad for [tiny-filter](/tiny-filter). Just build the 2 projects and you get a runnable jar 
that contains the entire package.

```bash

# first install tiny-filter
cd ../tiny-filter; mvn install; cd ../tiny-filter-launcher; mvn package

# run & enjoy
java -jar target/com.pfalabs.scala-osgi-trials.tinyfilter-launcher-*.jar

```

Navigate to [localhost:8080](http://localhost:8080)



