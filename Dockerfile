#################################################
#                                               #
#                                               #
#                Image Building                 #
#                                               #
#                                               #
#################################################


FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app
COPY pom.xml /app/

RUN mvn dependency:go-offline -B

COPY src /app/src/

RUN mvn clean install -DskipTests



#################################################
#                                               #
#                                               #
#            Building the Final Image           #
#                                               #
#                                               #
#################################################


FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/ethsite-0.0.1.jar /app/ethsite.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ethsite.jar"]