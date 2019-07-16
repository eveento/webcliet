FROM ubuntu:16.04

# Install prerequisites
RUN apt-get update && apt-get install -y \
curl

RUN apt-get install -y openjdk-8-jdk
# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

ADD webcliet-0.0.1-SNAPSHOT.jar app.jar
ADD chromedriver/chromedriver chromedriver

RUN bash -c 'chmod 755 chromedriver && touch /app.jar'

# Install Chrome for Selenium
RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb || apt-get install -yf
RUN rm /chrome.deb

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]