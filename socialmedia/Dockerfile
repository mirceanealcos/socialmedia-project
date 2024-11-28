FROM alpine:latest
WORKDIR /app/socialbuggy
RUN apk add --no-cache \
    bash \
    openjdk21 \
    maven
COPY . .
CMD ["sh", "-c", "mvn clean install;java -jar target/socialmedia-0.0.1-SNAPSHOT.jar"]