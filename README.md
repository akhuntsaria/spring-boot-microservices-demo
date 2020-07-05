# Structure
Project consists of 3 microservices:
* **movie-service**: contains information about movies (their id and name)
* **user-service**: contains information about users (their id and full name)
* **movie-review-service**: contains information about which user gave what review to a movie
    * movie-review-service is the main service, which calls other ones to get additional information.

# Getting Started
* Run all 3 services
* Call "GET http://localhost:8080/api/v1/reviews/users/1"