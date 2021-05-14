# BoxTicketing

## Intro
In this repository, we've implemented a proof of concept showing how easy it is to implement a REST API using Spring Boot.

## Setup
Run a MySQL server, create a database and modify the `applications.properties` file accordingly.

Run the API using the command
```
mvn clean spring-boot:run
```

and, once the server is started, issue in the MySQL command line:

```
INSERT INTO role(name) Values ('ROLE_ADMIN'), ('ROLE_USER');
```

Download Postman and import the file `EVENT_API_Postman.json`.

You will first have to sign up and admin by using the following request body:
```
{
  "username": ${USERNAME},
  "password": ${PASSWORD},
  "role":[
      "admin"
   ],
   "amountInWallet": ${AMOUNT}
}   
```

Once signed in, the admin will be able to create events and ticket types.

Then, you'll have to sign up a regular user by omitting the `role` field from the request body and will be able to buy tikets and check the tickets that were already purchased.
