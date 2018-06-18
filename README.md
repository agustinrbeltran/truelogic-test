# TruelogicTest

How to start the TruelogicTest application
---

1. Run `mvn clean package` to build your application
1. Start application with `java -jar target/truelogic-1.0-SNAPSHOT.jar server config/config.yml` or `sh deploy.sh`
1. To check that your application is running enter url `http://localhost:8080/swagger`
1. To start the application into a docker container (image openjdk:8-jre-alpine) run `docker-compose up`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Use Case Diagram
---
![image](https://user-images.githubusercontent.com/20670067/41552987-ceb9a780-7306-11e8-8c72-05af58160d63.png)



Data Model (relational model)
---
![image](https://user-images.githubusercontent.com/20670067/41553272-9bf92f40-7307-11e8-984a-72fcfcebac9c.png)


Package Diagram
---
![image](https://user-images.githubusercontent.com/20670067/41553138-3e9892dc-7307-11e8-96c4-fce714f80b55.png)


