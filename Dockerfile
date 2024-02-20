FROM openjdk:17
ADD target/scheduler-jobs.jar scheduler-jobs.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","scheduler-jobs.jar"]