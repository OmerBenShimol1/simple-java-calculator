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

Pipeline run results:
![image](https://github.com/user-attachments/assets/e3cd4b0e-ff69-4bcc-88e9-511f830c03f0)
![image](https://github.com/user-attachments/assets/1851bced-e857-4da9-ae5f-442f54209265)
![image](https://github.com/user-attachments/assets/216cec48-a131-4fdf-a885-a976d369f93b)
![image](https://github.com/user-attachments/assets/ed8415c4-be07-4064-8b2e-dc969b1cde10)
![image](https://github.com/user-attachments/assets/73c07d76-5f07-42bd-aca9-ace912d0a6bb)
![image](https://github.com/user-attachments/assets/37b2fddf-a6d8-4739-8476-6d6bec4a1029)





Failed the tests by purpose to make sure that the pipeline does not create a new dockerfile.
![TestsFailed](https://github.com/user-attachments/assets/9523ec40-0806-430f-a4c1-8ae5edd09872)

Helm with Kubernetes run:
![image](https://github.com/user-attachments/assets/d59c01ec-5da7-4e7c-9142-6d6c33ad3abf)





Project Tree:


```
|   docker-compose.yaml
|   Dockerfile
|   Dockerfile.app
|   Jenkinsfile
|   pom.xml
|   README.md
|
+---calc-chart
|   |   .helmignore
|   |   Chart.yaml
|   |   values.yaml
|   |
|   +---charts
|   \---templates
|       |   job.yaml
|       |   service.yaml
|       |   _helpers.tpl
|       |
|       \---tests
|               test-connection.yaml
|
+---lib
|       hamcrest-core-1.3.jar
|       junit-4.13.2.jar
|       junit-platform-console-standalone-1.13.0-M3.jar
|
+---src
|       Calculator.java
|       CalculatorApp.java
|
\---test
        CalculatorTest.java
```



















# Workflow

## 1. Building the Java Calculator App

1.1 Calculator.java – Calculator class that implements add, subtract, multiply, and divide operations.

1.2 CalculatorApp.java - Main class. A simple calculator program.


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

## 6. Deployment with Docker Compose






















