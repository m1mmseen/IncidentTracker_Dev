FROM openjdk:20

WORKDIR /app

COPY /target/incidenttracker.jar /app

EXPOSE 8080

CMD ["java", "-jar", "incidenttracker.jar"]