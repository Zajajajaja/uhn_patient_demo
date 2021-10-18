# uhn_patient_demo
Installation:
navigate to the project folder, ensure your jdk is up to date along with mvn. Run with "mvn spring-boot:run."
The service should be running now on localhost:8080.

Use:
GET with no parameters gives you the entire patient listing as it currently is. 
GET with /id/{id} will get you the patient with the specific id given, if it does not exist it will give you a 404 with a message telling you the specific number that isn't found.
GET with /firstName/{firstName} will get you the patient with the specific firstName given, if it does not exist it will give you a 404 with a message telling you the specific name that isn't found.
POST with the properly formed json (eg firstName, lastName, dateOfBirth in date format) will give you a 201 if accepted and a 400 bad request if its malformed in any way.

Tests:
I was unable to get the mvc tester working properly in eclipse/springboot but it would've been a mockito thing that would try to generate a list, add a person, query to see if the person was the only element on the list, then add another person and do the same with 2 patients. In general my automated and unit testing skills are limited to the framework i've been using recently (I think its just junit with some hibernate stuff on it for server work?) but I was able to learn enough to set up some of them here.

Errata:
I know this is very bare bones, a real system would involve MUCH more authentication between requests and likely never divulge all patients without a seriously good reason. This is the first time i've done this on my local computer so a lot of the work was set up and trying to cut the large amounts of chaff from the wheat i needed to run a program and see its results in Postman. Primarily if I had infinite time I'd set up a lot more testing that would hit every single part of the DAO and the controller but I was really unable to get Mockito doing what I wanted over the weekend. Lemme know what you think!
