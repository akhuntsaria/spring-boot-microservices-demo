# Structure
Project consists of 3 microservices and 1 discovery server:
* **discover-server**: Eurika server
* **movie-service**: contains information about movies (their id and name)
* **user-service**: contains information about users (their id and full name)
* **movie-review-service**: contains information about which user gave what review to a movie
    * movie-review-service is the main service, which calls other ones to get additional information.

# Getting Started
* Run discovery-server and 3 services
* Call "GET http://localhost:8761/" (to confirm that services were registered)
* Call "GET http://localhost:8081/api/v1/reviews/users/1" (to see result of loading data from different services)