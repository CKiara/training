FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /app/
WORKDIR /app
COPY "/target/account-1.0-SNAPSHOT.jar" .
COPY "/config.prod.yml" "config.yml"
EXPOSE 8082
EXPOSE 8083
ENTRYPOINT ["java","-jar","account-1.0-SNAPSHOT.jar", "server", "config.yml"]
