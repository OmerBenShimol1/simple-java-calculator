# Start from the official Jenkins LTS image
FROM jenkins/jenkins:lts

# Switch to root to install software
USER root

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# Install Docker CLI
RUN apt-get update && \
    apt-get install -y \
        ca-certificates \
        curl \
        gnupg \
        lsb-release && \
    mkdir -m 0755 -p /etc/apt/keyrings && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg && \
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] \
    https://download.docker.com/linux/debian $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null && \
    apt-get update && \
    apt-get install -y docker-ce-cli && \
    apt-get clean

# Stay as root to allow Docker CLI usage inside Jenkins
USER root



