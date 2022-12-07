FROM azul/zulu-openjdk:11

RUN apt-get update
RUN apt-get install -y maven \
gnupg2 \
wget \
less \
curl \
&& rm -rf /var/lib/apt/lists*


# Google Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get -y update

# install google chrome
RUN apt-get install -y google-chrome-stable
RUN apt-get install -yqq unzip

# Download the Chrome Driver
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get -y update
RUN apt-get install -y google-chrome-stable

# install chromedriver
RUN apt-get install -yqq unzip
RUN wget -O /tmp/chromedriver.zip http://chromedriver.storage.googleapis.com/`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`/chromedriver_linux64.zip
RUN unzip /tmp/chromedriver.zip chromedriver -d /usr/local/bin/

########################
#
#RUN apt-get update
#
#
#
## Set display port as an environment variable
##ENV DISPLAY=:99


#RUN google-chrome --no-sandbox
RUN mkdir /usr/test
COPY junit-platform-console-standalone-1.9.0.jar /usr/test
COPY target/vanilla-1.0-SNAPSHOT.jar /usr/test
WORKDIR /usr/test

CMD ["java", "-jar", "junit-platform-console-standalone-1.9.0.jar", "-cp" ,"./vanilla-1.0-SNAPSHOT.jar", "--select-package", "amazon.test"]
