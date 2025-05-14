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
