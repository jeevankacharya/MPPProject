FROM openjdk:8
ADD /MPPProject/build/libs/mppproject-1.0.jar   mppproject-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","mppproject-1.0.jar"]