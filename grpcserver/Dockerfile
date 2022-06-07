FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /app/
WORKDIR /app
COPY "./target/grpcserver-1.0-SNAPSHOT.jar" .
COPY "./config.prod.yml" "config.yml"
EXPOSE 8080
EXPOSE 8081
EXPOSE 8084
ENTRYPOINT ["java","-jar","grpcserver-1.0-SNAPSHOT.jar", "server", "config.yml"]
