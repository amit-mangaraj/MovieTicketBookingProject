# Book My Show (bms-master)
## Contributors List
Name                             |   PS No.  |      
---------------------------------|-----------|
`1) Vinayak`               | 99003555  |   
`4) Amit`               | 99003566  |
`3) Soumyajeet     `     | 99003548  |      
`4) Roshan`             | 99003576  | 
`5) Sirisha`             | 99003526  | 

## Implementation

1. Application is developed in Spring Boot 2.0.0 with Java 8 on Spring Tool Suite IDE. Database used is MySQL 5.7.17 and Hibernate JPA.

2. You can book movie tickets using the application.

3. Mandatory entities to book a ticket are - user, movie, screen with seats, shows of configured movies in configured screen with seats.

4. Logging/Registration must be performed to access the application. 

5. Session management is being implemented.



## Assumptions

For the simplicity of system, we have made following assumptions while implementing the solution -

1. Single User Model - One user will use at once. No locking implemented for seat selection. 
2. Single Screen Theaters - No multiple screen handling for a theater has been done. However an option is given for future scope.
3. Payment/checkout flow used on static base.


## Setup the Application

1. update the application.properties file provided in `src/main/resources` for relevant database changes.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Setting up the data

1. Access the application on `http://localhost:8080/`

2. Execute the `http://localhost:8080/adduser  This will create a sample user,and futher flow to add movie, screen, that will be used in booking ticket.


## Booking a ticket

1. Use the `booking-controller` to book a ticket from the list of movies.

2. Select any movie from the above search result.

3. select the no of seats 

4. The checkout-controller gives the total amount and proceed to checkout.

5. The invoice is generated for every transaction.

This will book a ticket for you and you will get ticket id along with show details in response.


## Verifying the results from DB / DB operations performed through Hibernate JPA , given below are equivalent sql queries 

1. Login to your MySQL and go to `bookmyshow` DB

2. `SELECT * FROM bookmyshow.users;` to see all registered users.

3. `SELECT * FROM bookmyshow.movies;` to see all movies.

4. `SELECT * FROM bookmyshow.screen;` to see all screens.

6. `SELECT * FROM bookmyshow.movie;` to see all shows for movies in theaters.

7. `SELECT * FROM bookmyshow.booking;` to see all booked tickets.


## Other API Details

1. `UserController` -  API to add and get user

2. `MovieController` - API to add and get movie

3. `ScreenController` - API to add and get screen

4. `BookingController` - API to perform booking


## Future Scope

1. Seat locking during payment
2. Multiple Screen handling in theater
3. Seat management on the fly

