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

## Implementation Notes

There's a document 'Coding Test.docx' that describes the implementation details as required by the coding test. However, 
based on the understanding of crafting a production ready code, I have made the following assumptions and changes:

- using data classes for Employee and instead of using inheritance use `EmployeeType` enum to define the type of employee.
- separation for Person and for Employee is deliberate and to illustrate how we store data pertaining to Persons separately from data pertaining to Employees. This may not be needed in the real life application, but many times we may need to break down our data classes on the lines of scope ( personal details, employment details, etc)
- logic for vacation calculation and work days is moved to a separate class `VacationStrategy` out of `SalariedEmployee`, `HourlyEmployee`, etc classes
- using `EmployeeType` enum to define the type of employee and use it to define the number of annual vacation cap. 
- Employee data is stored in a `Map` in the `EmployeeDataStore` class. It's designed to be interfaced with as an actual data store. We can easily add DB connection capabilities with the minimum of changes scoped to that `EmployeeDataStore` class.

This achieves flexibility for further changes and also makes the code more readable and maintainable as well as following separation of concerns - data are separated from logic/code.

