FROM dorowu/ubuntu-desktop-lxde-vnc

# Remove broken Chrome repo
RUN rm /etc/apt/sources.list.d/google-chrome.list || true

# Install Java
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean

# Set working directory
WORKDIR /app

# Copy source code and libraries
COPY ./src /app/src
COPY ./lib /app/lib

# Compile Java GUI app
RUN javac -cp "lib/*" src/Calculator.java src/CalculatorApp.java

# Run GUI app inside the VNC-enabled container
CMD ["java", "-cp", "src:lib/*", "CalculatorApp"]
