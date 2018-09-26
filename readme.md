# Login REST Service
I'm actually enjoying this, so I'll take my time with it. I'll be creating the entire REST service properly from scratch. I don't have a lot of spare time these days, so this will take a while. I'm publishing the in-progress version, which you may have suggested to me.

I've seen how REST services are built at Avaloq, but I never had to actually write one completely from scratch. I'm discovering all the reasons behind the architecture I remember at my own pace, because that's how it sticks for longer in the future.

## Tech stack
**Java:** Migrating the project to Kotlin caused a lot of weird gradle/spring/kotlin dependency issues which were too time consuming - just focusing on the service instead.

**MongoDB:** After a lot of experience with Oracle, I decided to give my first NoSQL database. It's really refreshing to just store plain Java objects in the DB.
  
**Spring**  makes the plumbing between layers a breeze. Whatever MVC framework we were using at Avaloq required digging through XML files to accomplish what Spring does with a few short annotations.  
