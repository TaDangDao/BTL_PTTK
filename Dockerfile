FROM tomcat:9.0-jdk11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/BTL_PTTK.war /usr/local/tomcat/webapps/ROOT.war
