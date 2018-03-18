#AddressBookReader Application

The AddressBookReader is responsible for reading an AddressBook. The AddressBook
has an API which allows it to determine things like the number of a particular gender 
in the address book and also who is the eldest person in the address book.

**NOTE**: 
A decision was taken (which would normally be discussed with a Product Owner)
about how to handle people with the same birth date in the address book.
 
- Multiple people have the same birthdate (making them all the eldest), all will be returned
- One person is the eldest in the address book only he/she will be returned
- Address book is empty at the time of searching then no-one is returned

### Built With:
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html )was used to develop this application
* [Maven](https://maven.apache.org/) - Dependency Management (v3.2.5) 
* JAVA_HOME env-var should be setup correctly on the Path
* MAVEN_HOME env-var should be setup correctly on the Path

###Run main app:


###Run tests: