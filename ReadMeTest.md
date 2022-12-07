##






## How to execute the test?

You can execute the test in 2 methods:

- You can run using **mvn** command in your local machine
- You can run using **docker image** 

### Executing using mvn:

**Pre-requisite:**

- Need to install mvn
- Need to install jdk
- Need to install Chrome browser

**Steps:**

1. clone the repo:
> git@github.com:nandansn/vanilla.git
2. execute the following commands
> mvn clean install
> mvn surefire:test
3. You can find the report in the following path
> ./vanilla/target/site/surefire-report.html


## Executing using docker

The test project is published as docker image. So, you can pull the image from the docker registry and run the test.

**Pre-requisite:**

- Need to install docker
- docker daemon should be up and running

**Steps:**

1. clone the repo:
> git@github.com:nandansn/vanilla.git
2. execute the following commands
> mvn clean install
> mvn surefire:test
3. You can find the report in the following path
> ./vanilla/target/site/surefire-report.html


## 
