FROM openjdk:11-jre-slim

WORKDIR /app

COPY ./target/bachelorapi.jar ./app.jar

CMD ["java", "-jar", "app.jar"]
