FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
