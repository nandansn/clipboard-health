# ![](https://clipboardhealth.com/wp-content/uploads/2022/02/CBH-Logo-1200x628-721-DPI.png)

# Clipboard Health - Coding Exercise
***

This test project is build on top of a base framework [Vanilla](git@github.com:ClipboardHealth/vanilla.git), as part of the test project we automated the following use case,

**Test Steps:**

- Open web: amazon.in
- Click menu, item category
- Click on Televisions under Tv, Audio & Cameras sub section.
- Scroll down and filter the results by Brand ‘Samsung’.
- Sort listed items by "Price: High To Low"
- Open or click second item in the sorted list
- Switch to child window
- Validate the text "About this item" in the Item Description section
- Get the "About this item" and log it in the console.


## Test Components

1. Infra Components
    1. Driver Factory, URL Factory, Env Factory these components help to initialize the browser and driver objects required for application interaction
2. Page Components
    1. Base Page, Menu, ProductPage etc help to initiate the page elements and provides methods to perform actions on the web elements like click, type etc.
3. Test Components
    1. Test class, Test Methods used to define the test steps and pass test data to perform the testing on the web application.


## Technology stack

- Java
- Junit
- Selenium Webdriver
- Docker
- Maven


## How to execute the test?

You can execute the test in 2 ways:

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


## Executing in docker container

The test project is published as docker image. So, you can pull the image from the docker registry and run the test.

**Pre-requisite:**

- Need to install docker
- docker daemon should be up and running

**Steps:**

1. pull and execute the docker using following command
> docker run  geeknandadocker13/clipboard-test


***

