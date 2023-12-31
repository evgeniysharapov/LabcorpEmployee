# LabcorpEmployee
Labcorp Java Coding Excercise

## Build and Compile 

Building the application is as simple as running the following command in the root of the project:

    mvn clean compile assembly:single

This will create a `target` directory with a jar file in it. This is the executable jar file that you can run.

## Running the application

As a developer, you can run the following command to start the application in a hot-swap mode:

    mvn spring-boot:run

This should start application on port 8080. You can access the application by visiting http://localhost:8080


