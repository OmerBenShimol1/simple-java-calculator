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
![image](https://github.com/user-attachments/assets/9d37d627-0da2-42d5-9cc5-5304c36b97e4)




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
+---target
|   +---classes
|   |       Calculator.class
|   |       CalculatorApp.class
|   |
|   \---test-classes
|           CalculatorTest.class
|
\---test
        CalculatorTest.java
```
