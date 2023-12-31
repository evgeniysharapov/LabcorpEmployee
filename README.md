# LabcorpEmployee
Labcorp Java Coding Excercise

## Build and Compile 

Building the application is as simple as running the following command in the root of the project:

    mvn clean compile package

This will create a `target` directory with a jar file in it. This is the executable jar file that you can run.

## Running the application

As a developer, you can run the following command to start the application in a hot-swap mode:

    mvn spring-boot:run

This should start application on port 8080. You can access the application by visiting http://localhost:8080

After application is running you can use command line `curl` command or a Postmat (see its own page for documentation).

Get all employees:

    curl -X GET -H "Content-Type: application/json"  http://localhost:8080/employee

Get a specific employee:

    curl -X GET -H "Content-Type: application/json"  http://localhost:8080/employee/1   

Add work days to an employee:

    curl -X PUT -H "Content-Type: application/json"  http://localhost:8080/employee/1/work/1 

Taking a vacation for a specific employee:

    curl -X PUT -H "Content-Type: application/json"  http://localhost:8080/employee/1/vacation/1


## Testing the application      


Run tests with `mvn test`, you can also test the application by running the following command:

    mvn verify

