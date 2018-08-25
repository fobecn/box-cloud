FROM fabric8/java-centos-openjdk8-jdk
LABEL app="myApp" version="0.0.1" by="daji"
VOLUME /tmp
ADD ./config-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD java -jar app.jar

#docker build -t cloud-config .
#docker run -p 8888:8888 -t cloud-config
#config.log (Permission denied)
#docker run  -p 8888:8888 -t --privileged=true cloud-config


