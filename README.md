# Description

A wrapper for the Finnish Transport Agency's [API](https://github.com/finnishtransportagency/digitraffic/wiki/rajapinnat) for real time traffic data.

Is also a demo/test-project for Kotlin.

Uses Spring Boot

# Usage

Generate the needed beans from wsdl

```
wsimport -d wsdl-beans <url>
```

Generates on bootup a default password for the user "user", if no users.properties is specified.

users.properties format:
```
user=password,role
```
For example:
```
tom=tomspw,API_USER
```


Starting the server

```
gradle bootRun
```

# TODO

* gradle-task for generating beans