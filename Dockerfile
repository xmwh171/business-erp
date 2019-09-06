FROM java:8-jre
MAINTAINER zyh <1209325963@qq.com>
ADD ./business-erp-0.0.1-SNAPSHOT.jar /app/
CMD java -jar $JAVA_OPTS  /app/business-erp-0.0.1-SNAPSHOT.jar
EXPOSE 8080
