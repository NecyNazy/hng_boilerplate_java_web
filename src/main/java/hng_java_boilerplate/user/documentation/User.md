
## **User SignUp**

### **Endpoint**

- **URL**: `/api/v1/auth/register`
- **Method**: `POST`
- **Content-Type**: `application/json`

### **Description**

The `User Signup` feature to enhance user engagement and onboarding experience. This feature should include user registration, account creation, and authentication processes.

### **Request Fields**

- **`firstName`** (required)
  - **Description**: First name of the user.
  - **Type**: `String`
  - **Example**: `John`

- **`lastName`** (required)
    - **Description**: Last name or surname of the user.
    - **Type**: `String`
    - **Example**: `Doe`

- **`email`** (required)
    - **Description**: Unique email of the user that serves as the username that will be used for login.
    - **Type**: `String`
    - **Example**: `johndoe@example.com`

- **`password`** (required)
    - **Description**: Password must be at least 8 characters long and contain alphanumeric characters.
    - **Type**: `String`
    - **Example**: `Ofe4ki!2`

```bash
curl -X POST http://localhost:8080/api/v1/auth/register \
-H "Content-Type: application/json" \
-d '{
      "firstName": "John",
      "lastName": "Doe",
      "email": "johndoe@example.com",
      "password": "Johndo3!"
    }'
```
#### * Using Postman
i. Open Postman.

ii. Create a new POST request.

iii. Enter the endpoint URL: http://localhost:8080/api/v1/auth/register.

iv. Set the request body type to raw and select JSON from the dropdown.

v. Paste the following JSON into the body:
```
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com",
  "password": "Johndo3!"
}
```
vi. Click on the `Send` button.


### **Responses**

#### **Success Response**

- **Status Code**: `200 OK`
- **Content-Type**: `application/json`
- **Response Body**:
```json

{
  "status_code": 201,
  "message": "Registration Successful!",
  "data": {
    "token": "some-token",
    "user": {
      "id": "some-user-id",
      "first_name": "John",
      "last_name": "Doe",
      "email": "johndoe@example.com",
      "created_at": "2024-07-19T20:28:34.399829"
    }
  }
}
  ```


#### **Validation Error Response**

- **Status Code**: `422 Unprocessable Entity`
- **Content-Type**: `application/json`
- **Response Body**:

  ```json
  {
    "message": "password: Password must be at least 8 characters long and contain alphanumeric characters; ",
    "error": "Validation failed",
    "status_code": 422
  }

### **Additional Information**

   - update the `application.properties` file with SHA512 secret key (for JWT setup)

```html
<!-- flyway configuration-->
sha512.string={SHA_SECRET}
```

* Ensure your server is running on localhost:8080 before making the request.

* The firstName, lastName, email, and password fields are required.

* The password must meet your application's password strength requirements.

* Check your database to verify the user has been created successfully after a successful registration.

## **Facebook login**

### **Endpoint**

- **URL**: `/api/v1/auth/facebook`
- **Method**: `POST`
- **Content-Type**: `application/json`

### **Description**

The `Facebook login` feature to enhance user engagement and onboarding experience. This feature should include user registration, account creation, and authentication processes using facebook social oauth service for facebook account owners.


#### * Using Postman
i. Open Postman.

ii. Create a new POST request.

iii. Enter the endpoint URL: http://localhost:8080/api/v1/auth/facebook.

iv. Set the request body type to raw and select JSON from the dropdown.

v. Paste the following JSON into the body:
```
{
  "access_token": "string",
  "expires_in": "integer",
  "refresh_token": "string",
  "scope": "string",
  "token_type": "string",
  "id_token": "string",
  "expires_at": "long",
  "provider": "string",
  "type": "string",
  "provider_account_id": "string",
  "verified_user_id": "string"
}
```
vi. Click on the `Send` button.


### **Responses**

#### **Success Response**

- **Status Code**: `200 OK`
- **Content-Type**: `application/json`
- **Response Body**:
```json

{
  "status_code": 200,
  "message": "Registration Successful!",
  "data": {
    "token": "some-token",
    "user": {
      "id": "some-user-id",
      "first_name": "John",
      "last_name": "Doe",
      "email": "johndoe@example.com",
      "role": "USER",
      "img_url": "http://example.com/picture",
      "created_at": "2024-07-19T20:28:34.399829"
    }
  }
}
  ```

* Ensure your server is running on localhost:8080 before making the request.
* Ensure you have registered on Facebook Developers Console account gotten your credentials to make use for testing the endpoint on postman
* Check your database to verify the user has been created successfully after a successful registration.


## **Google login**

### **Endpoint**

- **URL**: `/api/v1/auth/google`
- **Method**: `POST`
- **Content-Type**: `application/json`

### **Description**

The `Google login` feature to enhance user engagement and onboarding experience. This feature should include user registration, account creation, and authentication processes using google social oauth service for google account owners.


#### * Using Postman
i. Open Postman.

ii. Create a new POST request.

iii. Enter the endpoint URL: http://localhost:8080/api/v1/auth/google.

iv. Set the request body type to raw and select JSON from the dropdown.

v. Paste the following JSON into the body:
```
{
  "access_token": "string",
  "expires_in": "integer",
  "refresh_token": "string",
  "scope": "string",
  "token_type": "string",
  "id_token": "string",
  "expires_at": "long",
  "provider": "string",
  "type": "string",
  "provider_account_id": "string",
  "verified_user_id": "string"
}
```
vi. Click on the `Send` button.


### **Responses**

#### **Success Response**

- **Status Code**: `200 OK`
- **Content-Type**: `application/json`
- **Response Body**:
```json

{
  "status": 200,
  "message": "Registration Successful!",
  "data": {
    "token": "some-token",
    "user": {
      "id": "some-user-id",
      "first_name": "John",
      "last_name": "Doe",
      "email": "johndoe@example.com",
      "role": "USER",
      "img_url": "http://example.com/picture",
      "created_at": "2024-07-19T20:28:34.399829"
    }
  }
}