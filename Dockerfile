
FROM tomcat:8.5.16-jre8-alpine
COPY ./hrd_emp_be-0.0.1-SNAPSHOT.jar hrd_emp_be-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","hrd_emp_be-0.0.1-SNAPSHOT.jar"]




