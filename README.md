[![][maven img]][maven]
[![][travis img]][travis]

A ready-to-use LifeCycle that sets up logging. It assumes you're using SLF4J, Logback, Gelf and Jindy. If this is not the case, you can easily make your own logging configuration bootstrap using this one as a reference (or don't).

## Usage

In your application bootstrap, run the following code
```java
LoggingLifecycle l = new LoggingLifecycle();
l.start();
```

[maven]:http://search.maven.org/#search|gav|1|g:"org.irenical.loggy"%20AND%20a:"loggy"
[maven img]:https://maven-badges.herokuapp.com/maven-central/org.irenical.loggy/loggy/badge.svg

[travis]:https://travis-ci.org/irenical/loggy
[travis img]:https://travis-ci.org/irenical/loggy.svg?branch=master
