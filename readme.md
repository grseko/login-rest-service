# Login REST Service
A full REST service using **Java**, **Spring Boot** and **MongoDB** with separate REST, Business and Database layers.

This REST service was created as a programming challenge for a job application. The challenge was focused on the separation of the different layers, not on the login functionality itself. This is why we're storing the password in plaintext instead of salting and hashing it :)
  
This project pushed me to learn not just *how* REST services are built, but also *why* they're usually built in a certain way. On top of that, I chose a couple of technologies I've never used before (MongoDB, Spring Boot).

## Architecture
Throughout the design, I'm trying to keep the code as modular as possible to make it easier to add more REST services in the future.

**REST layer *(com.grseko.rest)*** exposes two REST endpoints in `UserRestController` and is responsible for the format of the transfer object `UserDTO`. The endpoints call the BUSINESS layer after unwrapping the transfer object. Because of the simplicity of this REST service, the DTO is never directly converted into the business object.

**BUSINESS layer *(com.grseko.service)*** contains the business logic in `UserService`. The service doesn't know anything about the layer above it, so it doesn't use DTO objects which belong to the REST layer. It communicates with the DATABASE layer through an injected implementation of a DAO interface, so it's not aware of the specific Database implementation underneath.
 
**DATABASE layer *(com.grseko.database)*** exposes the model/entity and a generic `UserDAO` interface, keeping specific implementations hidden. It's not aware of the layer above it in any way.  

Top-level **APPLICATION layer *(com.grseko)*** is responsible for configuration, i.e. defining the Beans to specify what specific implementations should be used throughout the application.  
In the current version, it also runs a few commands to make testing easier at startup.

## Tech stack
**Java:** This is my main programming language these days. I wanted to try Kotlin, but I couldn't spend the time on learning a new language for a programming challenge in the middle of job-searching. If it wasn't for the time constraints, I'd have given Kotlin a bash :)

**MongoDB:** After a lot of experience with Oracle, I decided to try the other end of the specturm - a NoSQL database. MongoDB is *the* NoSQL database these days, so I didn't spend much time thinking it over. It's really refreshing to use it :) I feel like I'd need a more complex model to properly understand all the differences though - I only have one object, so I wouldn't have any relations in a relational database either!
  
**Spring Boot** makes the plumbing between layers a breeze. I built an entire service without a single XML file! I honestly don't know what I used at my first workplace, but Spring Boot is definitely nicer to work with.

**JUnit 5 + Mockito 2:** The JUnit + Mockito combination is battle-hardened and field-tested :) JUnit 5 offers a lot of nice syntax upgrades from JUnit 4. For example, I like the more intuitive `assertThrows` which also provides a good way of checking the exception message.

**Gradle:** I chose Gradle mostly to keep my project XML-free. I've used it a little before and I still don't feel like I truly get it. The next step is to harness the power of Gradle tasks!

## Further Development
* Configure MongoDB not use the default database.
* Add integration tests.
* Remove the debug commands from the `Application` class.
* Salt & hash the passwords as the `User` is being created (probably make it part of `User.setPassword`).
* ...and much further on, create a separate session manager module/project to keep this going?

## Copyright
````
Copyright 2018 - Grzegorz Sebastian Korkosz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
