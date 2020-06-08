FROM openjdk:8
ADD target/spring-cucumber-test.jar spring-cucumber-test.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "spring-cucumber-test.jar"]