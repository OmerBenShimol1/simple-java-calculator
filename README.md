# simple-java-calculator
Project Description:
This project demonstrates a full DevOps pipeline built around a simple Java calculator app. It showcases how to automate testing, containerization, and deployment using popular tools like Jenkins, Docker, and Kubernetes.

Technologies Used:
Java
Maven
JUnit 5
Jenkins
Docker
Docker Compose
Kubernetes
Helm

Development & DevOps Workflow:
Java Development – Basic calculator with operations like add, subtract, multiply, divide.
Unit Testing – JUnit 5 tests to validate each method.
CI with Jenkins – Pull from GitHub, run tests, build Docker image, publish results.
Dockerization – Dockerfile to package the application.
Local Environment – Use Docker Compose to run Jenkins and the app.
Kubernetes Deployment – Helm chart used for production-style deployment.

CI/CD Process with Jenkins:
The Jenkins pipeline performs the following steps:
Clones the GitHub repository
Runs unit tests using Maven
Builds a Docker image - only if all the unit tests passed
Pushes the image to Docker Hub
Archives test results and logs

# Workflow

## 1. Building the Java Calculator App

1.1 Calculator.java – Calculator class that implements add, subtract, multiply, and divide operations.

1.2 CalculatorApp.java - Main class. A simple calculator program.

## 2. Writing Unit Tests (JUnit)
CalculatorTest.java - a tests class that contains 1 test for each operator and another 1 for division by zero.

## 3. Building with Maven (Created pom.xml file)
Added dependencies, configured default build and test phases, also, made sure that the source folder structure matches Maven's expectations.

## 4. Application's Docker Image creation
#### Dockerfile.app - uses OpenJDK base image, copies related folders (src, lib), compiles .java files and runs the app with java.
```docker build -t omerbs/calculator-app .```


## 5. Docker Image created for Jenkins's container
#### 5.1. Built a new Dockerfile for Jenkins.
To run Maven inside Jenkins I had to add Maven's installation to the Docker Image.
For the part of the Java application image creation I had to also install Docker CLI inside Jenkins container.
After that, I could run this Jenkin's pipeline well.

#### 5.2. Wrote a Jenkinsfile for the pipeline.
Stage 1: Clone from GitHub

Stage 2: Run mvn clean test + publish JUnit test results

Stage 3: Build Docker image

Stage 4: Push image to Docker Hub

Post block: Handle success, failure, always messaging

The Jenkins pipeline ran successfully and completed, cloned the right GitHub repository, JUnit tests ran and passed succesfully and the test results were archived.

![image](https://github.com/user-attachments/assets/0ce72f57-17c1-4e36-884e-e71967c80509)

Pipeline's overview:

![image](https://github.com/user-attachments/assets/6545c06a-b971-4eb2-8a44-7b366f5c9a0e)

Test results:

![image](https://github.com/user-attachments/assets/fcb9582b-4de8-4d55-b6a9-494d51505111)

Docker Image publishing process:

![image](https://github.com/user-attachments/assets/66f407e6-0e5a-4f07-915c-66be52e1d2d6)

![image](https://github.com/user-attachments/assets/e20b338b-25cb-4324-b33f-ccd5a7441df4)

tests XML file archived:

![image](https://github.com/user-attachments/assets/511c52da-2dd0-4072-ac08-a20037e058d4)

Image published to Docker Hub:

![image](https://github.com/user-attachments/assets/37b2fddf-a6d8-4739-8476-6d6bec4a1029)

Failed the tests by purpose to make sure that the pipeline does not create a new dockerfile.

![TestsFailed](https://github.com/user-attachments/assets/9523ec40-0806-430f-a4c1-8ae5edd09872)



## 6. Deployment with Docker Compose

wrote docker-compose.yml file that:
 
Pulls the published image from Docker Hub.
The user can change the parameters by editing the command line in the docker-compose.yaml file
```command: ["java", "-cp", "src:lib/*", "CalculatorApp", "4", "2", "+"]```
Type: ```docker-compose up --build to build the docker-compose```

Also, if the user wants to interact manually with the container they can change stdin_open and tty fields to 'true' and remove the ```command``` field.

To run the docker-compose.yaml:

```docker-compose run --rm calculator```

To stop the environment and remove any unused containers:

```docker-compose down --remove-orphans```

## 7. Kubernetes + Helm
7.1. Helm Chart creation
deployment.yaml - modified the template to dynamically receive:

- Image repo and tag

- Java command and args (which your app expects)

values.yaml - set the replicasCount to 1, added the image information and the args.

#### the user can change the inputs later by running the command:

```helm upgrade --install calc-app ./calc-chart --set a=10 --set b=20 --set op=-```

a, b can be changed to any number and op to one of the following: [ +, -, *, / ]


7.2. Deploy to Kubernetes Cluster

```helm upgrade --install calc-app ./calc-chart```


This command:

- Installs if not already installed.

- Upgrades the deployment if already exists.


Helm with Kubernetes run:
![image](https://github.com/user-attachments/assets/d59c01ec-5da7-4e7c-9142-6d6c33ad3abf)















