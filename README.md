<h1>Architecture of Microservices</h1>

1. Eureka Server is an application that holds the information about all client-service applications.
Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.
Eureka Server is also known as Discovery Server.

2. Create two microservices : Students and Schools.
- The business logic is not the scope of this task.

3. Each microservice has its own configurations and ports.
   - port for Schools: 8070
   - port for Students: 8090
   
4. Create a Gateway which manages both the microservices by using the port 8222
5. Extra: If needed there is config server to externalize the app. Not implemented yet ...
