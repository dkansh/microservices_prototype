FROM openjdk:8-jdk-alpine
EXPOSE 8101
ADD build/libs/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]