FROM docker.arvancloud.ir/openjdk:17-alpine

COPY ./target/reserve-0.0.1-SNAPSHOT.jar  /app/app.jar
#COPY ./axon/axonserver-2023.2.1.jar  /app/axonserver.jar
COPY ./data/* /app/data/
#RUN mkdir -p /app/data

WORKDIR /app
EXPOSE 9805
#CMD java -jar axonserver.jar & java -jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
