FROM amazoncorretto:11-alpine-jdk
MAINTAINER joabfg
COPY target/transactions-0.0.1-SNAPSHOT.jar transactions-server-0.0.1.jar
ENTRYPOINT ["java","-jar","/transactions-server-0.0.1.jar"]