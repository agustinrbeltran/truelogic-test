# TruelogicTest

How to start the TruelogicTest application
---

1. Run `mvn clean package` to build your application
1. Start application with `java -jar target/truelogic-1.0-SNAPSHOT.jar server config/config.yml or sh deploy.sh`
1. To check that your application is running enter url `http://localhost:8080/swagger`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
