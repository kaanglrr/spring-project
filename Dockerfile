FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springbootdockerapplication.jar
EXPOSE 8050
ENTRYPOINT ["java","-jar","/springbootdockerapplication.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]