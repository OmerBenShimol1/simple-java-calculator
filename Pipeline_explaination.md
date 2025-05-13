This project implements a complete CI (Continuous Integration) pipeline for a simple Java-based calculator application.
The pipeline is designed to automatically clone the repository, run unit tests, build a Docker image, and publish it to Docker Hub.

Workflow + explainations per stage:
1st stage: Clones the project from the main branch of the GitHub repository.

2nd stage: Cleans old compiled files and runs all unit tests by using the command: mvn clean test
Then collects JUnit test reports by using the command: junit 'target/surefire-reports/*.xml'

3rd stage: Builds a new Docker image using a custom Dockerfile (Dockerfile.app) using environment variables.

4th stage: Pushs the new Docker Image to Docker Hub - using Jenkins credentials to securely log in to Docker account, then log off securely.

Post actions: Archives the test results XML even if the pipeline failed.

