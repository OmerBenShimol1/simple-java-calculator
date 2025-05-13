FROM dorowu/ubuntu-desktop-lxde-vnc

# Remove broken Chrome repo
RUN rm /etc/apt/sources.list.d/google-chrome.list || true

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
CMD ["java", "CalculatorGUI"]
