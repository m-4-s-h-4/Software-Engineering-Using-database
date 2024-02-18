FROM openjdk:23-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/courier-quest-sql-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} courier-quest-sql.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/courier-quest-sql.jar"]
