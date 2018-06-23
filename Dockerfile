FROM gcr.io/google-appengine/openjdk:8
COPY truelogic.db truelogic.db
COPY target/truelogic-1.0-SNAPSHOT.jar truelogic.jar
COPY config/config.yml config.yml
CMD [ "java", "-jar","truelogic.jar", "server", "config.yml"]