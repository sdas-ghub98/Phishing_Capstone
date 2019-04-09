FROM openjdk
ADD target/Phishing.war Phishing.war
EXPOSE 8085
ENTRYPOINT ["java","-jar","Phishing.war"]