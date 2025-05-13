FROM openjdk:17

WORKDIR /app

COPY ./src /app/src
COPY ./lib /app/lib

RUN javac -cp "lib/*" src/Calculator.java src/CalculatorApp.java

CMD ["java", "-cp", "src:lib/*", "CalculatorApp"]