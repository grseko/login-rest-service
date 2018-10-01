# Login REST Service
A full REST service using **Java**, **Spring Boot** and **MongoDB** with separate REST, Business and Database layers.

## Purpose
This REST service was created as a programming challenge for a job application. The challenge was focused on the separation of the different layers, not on the login functionality itself. This is why we're storing the password in plaintext instead of salting and hashing it :)

The entire challenge was a learning process for me - at my previous workplace, I was mostly responsible for maintenance. When I developed REST endpoints there, I was just following existing convention. Since everything was already done for me, I never had to properly wrap my head around the architecture and the decisions behind it. Deadlines pressured me into just doing my job and not going out of my way to learn what I'm working with.  
This project pushed me to learn not just *how* REST services are built, but also *why* they're usually built in a certain way. On top of that, I chose several technologies I've never used before (MongoDB, Spring Boot).  
Overall, a fun project which I'll probably continue working on a little in my own time to keep my skills sharp.

## Architecture
**REST** layer *(com.grseko.rest)* exposes two REST endpoints in **UserRestController** and is responsible for the format of the transfer object **UserDTO**. The endpoints call the BUSINESS layer after unwrapping the transfer object. Because of the simplicity of this REST service, the DTO is never directly converted into the business object.

**BUSINESS** layer *(com.grseko.service)* contains the business logic in **UserService**. The service doesn't know anything about the layer above it, so it doesn't use DTO objects which belong to the REST layer. It communicates with the DATABASE layer through an injected implementation of a DAO interface, so it's not aware of the specific Database implementation underneath.
 
**DATABASE** layer *(com.grseko.db)* exposes the model/entity and generic DAO interfaces, keeping specific implementations hidden. It's not aware of the layer above it in any way.  

Top-level **APPLICATION** layer *(com.grseko)* is responsible for configuration, i.e. defining the Beans to specify what specific implementations should be used throughout the application.  
In the current version, it also runs a few commands to make testing easier at startup.

## Tech stack
**Java:** This is my main programming language these days. I wanted to try Kotlin, but I couldn't spend the time on learning a new language for a programming challenge in the middle of job-searching. If it wasn't for the time constraints, I'd have given Kotlin a bash :)

**MongoDB:** After a lot of experience with Oracle, I decided to try the other end of the specturm - a NoSQL database. MongoDB is *the* NoSQL database these days, so I didn't spend much time thinking it over. It's really refreshing to use it :) I feel like I'd need a more complex model to properly understand all the differences though - I only have one object, so I wouldn't have any relations in a relational database either!
  
**Spring Boot** makes the plumbing between layers a breeze. I built an entire service without a single XML file! I honestly don't know what I used at my first workplace, but Spring Boot is definitely nicer to work with.

**JUnit 5:** A lot of nice syntax upgrades from JUnit 4. For example, I like the more intuitive `assertThrows` which also provides a good way of checking the exception message.

**Mockito** is a no-brainer when it comes to proper unit testing in Java!

**Gradle:** I chose Gradle mostly to keep my project XML-free. I've used it a little before and I still don't feel like I truly get it. The next step is to harness the power of Gradle tasks!

## Further Development
* Turn the **User** class into an interface, create a **MongoUser** implementation.
* Break off the configuration part of **Application** class into a **Configuration** class to enforce separation of concerns.
* Configure MongoDB to not use the default database.
* Add integration tests.
* Remove the debug commands from the **Application** class.
* Salt & hash the passwords as the **User** is being created (probably make it part of `User.setPassword`).
* ...and much further on, create a separate session manager module/project to keep this going?
