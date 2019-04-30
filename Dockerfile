FROM tomcat:8.5.40-jre11
EXPOSE 8090
COPY /target/Phishing.war /usr/local/tomcat/webapps/ 