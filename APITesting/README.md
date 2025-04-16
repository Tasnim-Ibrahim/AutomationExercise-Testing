# Automation Exercise API Documentation

## Overview
This documentation covers the REST API endpoints available for Automation Exercise. The API allows you to interact with products, brands, user accounts, and more.

## Base URL
```
https://automationexercise.com/api
```

## Collection Information
**Collection Name:** Automation_API_Testing  

[![Run in Postman](https://run.pstmn.io/button.svg)](https://testing-team-8846.postman.co/workspace/DEPI_SWT_Project~6125e52a-0763-4acb-8b09-2e7e33bb1b46/collection/22302763-61f8cfd9-aae0-4f36-bacd-8f1c2d31d68b?action=share&creator=22302763
)

## Global Tests
All endpoints in this collection are configured with the following global tests:
```javascript
// Status code check
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Performance check
pm.test("Response time is less than 200ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(1000);
});
```

## Endpoints

### 1. Get All Products List
**Request:**
- **Method:** GET  
- **Endpoint:** `/productsList`

**Response:**
- **Status Code:** 200
- **Format:** JSON
- **Body:** Contains an array of products with properties:
  - `id` (number)
  - `name` (string)
  - `price` (string)
  - `brand` (string)
  - `category` (object)
    - `usertype.usertype` (string)
    - `category` (string)

---

### 2. POST To All Products List
**Request:**
- **Method:** POST  
- **Endpoint:** `/productsList`

**Response:**
- **Status Code:** 405  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 405,
    "message": "This request method is not supported."
  }
  ```

---

### 3. Get All Brands List
**Request:**
- **Method:** GET  
- **Endpoint:** `/brandsList`

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:** Contains an array of brands with properties:
  - `id` (number)
  - `brand` (string)

---

### 4. PUT To All Brands List
**Request:**
- **Method:** PUT  
- **Endpoint:** `/brandsList`

**Response:**
- **Status Code:** 405  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 405,
    "message": "This request method is not supported."
  }
  ```

---

### 5. POST To Search Product
**Request:**
- **Method:** POST  
- **Endpoint:** `/searchProduct`  
- **Body Parameters:**
  - `search_product` (string) – The product to search for

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:** Contains matching products

---

### 6. POST To Search Product without search_product parameter
**Request:**
- **Method:** POST  
- **Endpoint:** `/searchProduct`  
- **Body Parameters:** None

**Response:**
- **Status Code:** 400  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 400,
    "message": "Bad request, search_product parameter is missing in POST request."
  }
  ```

---

### 7. POST To Verify Login with valid details
**Request:**
- **Method:** POST  
- **Endpoint:** `/verifyLogin`  
- **Body Parameters:**
  - `email` (string) - User email
  - `password` (string) - User password

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 200,
    "message": "User exists!"
  }
  ```

---

### 8. POST To Verify Login without email parameter
**Request:**
- **Method:** POST  
- **Endpoint:** `/verifyLogin`  
- **Body Parameters:**
  - `password` (string) - User password

**Response:**
- **Status Code:** 400  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 400,
    "message": "Bad request, email or password parameter is missing in POST request."
  }
  ```

---

### 9. DELETE To Verify Login
**Request:**
- **Method:** DELETE  
- **Endpoint:** `/verifyLogin`

**Response:**
- **Status Code:** 405  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 405,
    "message": "This request method is not supported."
  }
  ```

---

### 10. POST To Verify Login with invalid details
**Request:**
- **Method:** POST  
- **Endpoint:** `/verifyLogin`  
- **Body Parameters:**
  - `email` (string) - User email
  - `password` (string) - User password

**Response:**
- **Status Code:** 404  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 404,
    "message": "User not found!"
  }
  ```

---

### 11. POST To Create/Register User Account
**Request:**
- **Method:** POST  
- **Endpoint:** `/createAccount`  
- **Body Parameters:**
  - `name` (string)
  - `title` (string)
  - `firstname` (string)
  - `lastname` (string)
  - `email` (string)
  - `password` (string)
  - `birth_date` (string)
  - `birth_month` (string)
  - `birth_year` (string)
  - `address` (string)
  - `company` (string)
  - `address1` (string)
  - `address2` (string)
  - `state` (string)
  - `city` (string)
  - `zipcode` (string)
  - `country` (string)
  - `mobile_number` (string)

**Response:**
- **Status Code:** 201  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 201,
    "message": "User created!"
  }
  ```

---

### 12. PUT METHOD To Update User Account
**Request:**
- **Method:** PUT  
- **Endpoint:** `/updateAccount`  
- **Body Parameters:**
  - `name` (string)
  - `title` (string)
  - `firstname` (string)
  - `lastname` (string)
  - `email` (string)
  - `password` (string)
  - `birth_date` (string)
  - `birth_month` (string)
  - `birth_year` (string)
  - `address` (string)
  - `company` (string)
  - `address1` (string)
  - `address2` (string)
  - `state` (string)
  - `city` (string)
  - `zipcode` (string)
  - `country` (string)
  - `mobile_number` (string)

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 200,
    "message": "User updated!"
  }
  ```

---

### 13. GET user account detail by email
**Request:**
- **Method:** GET  
- **Endpoint:** `/getUserDetailByEmail`  
- **Query Parameters:**
  - `email` (string) - User email

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 200,
    "user": {
      "id": 1,
      "name": "a A",
      "email": "hello@yahoo.com",
      "title": "Mrs",
      "firstname": "a",
      "lastname": "A",
      "birth_date": "17",
      "birth_month": "2",
      "birth_year": "1995",
      "address": "34524dsada",
      "company": "pep",
      "address1": "zd5d6asd",
      "address2": "54zdzdss",
      "state": "Cairo",
      "city": "Madrid",
      "zipcode": "54353",
      "country": "Spain",
      "mobile_number": "01232434243"
    }
  }
  ```

---

### 14. DELETE METHOD To Delete User Account
**Request:**
- **Method:** DELETE  
- **Endpoint:** `/deleteAccount`  
- **Body Parameters:**
  - `email` (string) - User email
  - `password` (string) - User password

**Response:**
- **Status Code:** 200  
- **Format:** JSON  
- **Body:**
  ```json
  {
    "responseCode": 200,
    "message": "Account deleted!"
  }
  ```

---

## Closing Note
Thank you for reviewing this documentation.

