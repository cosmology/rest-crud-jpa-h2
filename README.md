# 🚀 Spring Boot 3, Spring Data JPA, REST API

Sample REST API project exposes singe Spring Boot REST controller over Spring Data JPA and in-memory H2 database.
Its primary focus is applying best practices when building RESTful APIs through:

- Proper naming of RESTful API resources 
- Applying CRUD operations (GET, POST, PUT, PATCH, DELETE) on resources
- Providing valid responses and error handling (200, 201, 204, 404, 500) from CRUD operations.

## 🔖 **Running the project**
```bash
mvn clean install
```
```bash
mvn spring-boot:run
```

## 🔖 **Postman**

#### **Step 1: Import collection**

Import  [REST_CRUD.postman_collection.json](REST_CRUD.postman_collection.json)

#### **Step 2: Send individual requests**

RESTful APIs allow you to perform CRUD operations using the POST, GET, PUT, PATCH and DELETE HTTP methods.

This collection contains each of these [request](https://learning.postman.com/docs/sending-requests/requests/) types. Open each request and click "Send" to see what happens.

#### **Step 2: View responses**

Observe the response tab for status code (200 OK), response time, and size.

#### **Step 3: Send new Body data**

Update or add new data in "Body" in the POST request. Typically, Body data is also used in PUT request.

```
{
    "title": "New Title"
}

 ```

#### **Step 4: Update the variable**

Variables enable you to store and reuse values in Postman. I have created a [variable](https://learning.postman.com/docs/sending-requests/variables/) called `base_url` with the sample request [http://localhost:9090](http://localhost:9090). Replace it with your API endpoint's port to customize this collection if needed.

#### **Step 5: Add tests in the "Tests" tab**

Tests help you confirm that your API is working as expected. You can write test scripts in JavaScript and view the output in the "Test Results" tab.

<img src="https://content.pstmn.io/b5f280a7-4b09-48ec-857f-0a7ed99d7ef8/U2NyZWVuc2hvdCAyMDIzLTAzLTI3IGF0IDkuNDcuMjggUE0ucG5n">

#### **Step 6: Run entire collection**

- Click on REST CRUD in your collections sidebar and go to Runs tab
- Click 'Run REST CRUD' button to run the entire collection

## 🔖 **Benchmark**

POST a book then go to terminal:

```bash
ab -n 60 -c 20 http://localhost:9090/api/v1/book/1
```