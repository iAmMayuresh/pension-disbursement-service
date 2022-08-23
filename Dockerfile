FROM openjdk:8-jdk-alpine
EXPOSE 8084
ADD "target/pension-disbursement-service.jar" "pension-disbursement-service.jar"
ENTRYPOINT [ "java", "-jar", "/pension-disbursement-service.jar" ]