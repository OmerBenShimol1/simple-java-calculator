FROM dorowu/ubuntu-desktop-lxde-vnc

# Install Java
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean

# Set working directory
WORKDIR /app

# Copy app source code
COPY . /app

# Compile the Java GUI App
RUN javac Calculator.java CalculatorApp.java

# Run the GUI App when the container starts
CMD ["java", "CalculatorApp"]
