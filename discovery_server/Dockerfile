FROM openjdk:8-jdk-alpine
EXPOSE 8761
ADD build/libs/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]