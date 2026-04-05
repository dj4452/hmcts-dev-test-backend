# HMCTS Dev Test Backend
This will be the backend for the brand new HMCTS case management system. As a potential candidate we are leaving
this in your hands. Please refer to the brief for the complete list of tasks! Complete as much as you can and be
as creative as you want.

You should be able to run `./gradlew build` to start with to ensure it builds successfully. Then from that you
can run the service in IntelliJ (or your IDE of choice) or however you normally would.

There is an example endpoint provided to retrieve an example of a case. You are free to add/remove fields as you
wish.


This Fork involes changes 

Task Management Module (Added in this fork)
1. Create, read, update, delete tasks.
2.H2 in‑memory database.
3.JPA/Hibernate entity mapping.
4.Repository + Service + Controller layers.

Endpoints for testing:

1. /tasks --> getAll tasks
2. /getTask/{taskId} --> Get Task associated with ID.
3. /addTask --> Add the task
4. /updateTask/{taskId} --> Update the task.
5. /deleteTask/{taskId} --> Delete the task

H2 Database Console can be accessed as below steps,
   
1.URL: http://localhost:4000/h2-console
2.JDBC URL: jdbc:h2:mem:testdb
3.  Username: sa
    Password: (leave blank)

Input Sample :
    {
  "caseNumber": "12345",
  "createdDate": "2026-04-02T10:47:47.310Z",
  "description": "Case Description3", 
  "status": "Case Status3",
  "title": "Case Title3"
}
