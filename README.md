**Banking System API**
----------------------------------------------------------------------------------------------------
A simple banking system backend built with Java, Spring Boot, and JWT for authentication and authorization. This project demonstrates how to manage users, perform banking transactions, and secure API endpoints using JWT.
________________________________________________________________________________________________

**Features**
------------------------------------------------------------------------------
-**User Management:** 

  -Register and retrieve user information.

-**Banking Transactions:** 

  -Deposit and withdraw funds from user accounts.

-**JWT Authentication:** 

  -Secure API endpoints using JWT.

-**Error Handling:** 

  -Custom exception handling for authentication errors.
____________________________________________________________________________
**Technologies**
-------------------------------------------------------------------------
***Java 17**

***Spring Boot 3.0.0**

***Spring Security**

***JWT (Java JWT by JJWT)**

***ModelMapper**

***H2 Database (in-memory)**

***Maven**
____________________________________________________________________________
**API Endpoints**
------------------------------------------------------------------------------
**User Management**

**Register User**

    POST /users/register
    
    Request Body: { "username": "user", "password": "pass", "roles": ["USER"] }
    
    Response: { "id": 1, "username": "user", "roles": ["USER"] }

**Get User by ID**

    GET /users/{id}
    
    Response: { "id": 1, "username": "user", "roles": ["USER"] }

**Get User by Username**

    GET /users/username/{username}
    
    Response: { "id": 1, "username": "user", "roles": ["USER"] }
ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ

**Banking Transactions**

**Deposit Funds**

    POST /accounts/{accountId}/deposit

    Request Body: { "amount": 100.00 }

    Response: { "accountId": 1, "balance": 100.00 }

**Withdraw Funds**

    POST /accounts/{accountId}/withdraw
    
    Request Body: { "amount": 50.00 }
    
    Response: { "accountId": 1, "balance": 50.00 }
