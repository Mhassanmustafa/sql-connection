# sql-connection
Simple javafx project just for the connection with the sql server
This is a sample maven project mainly just for guidance on how to structure a simple javafx project. This does not goes into how would you deploy your app. Although that does gets a lot easier if its structured right. 
Also it gives connection with the sql server.

![Capture](https://user-images.githubusercontent.com/48490719/55896762-7b3a6980-5bd8-11e9-88fc-0da5e39398a5.PNG)

# Compile
the project can be cmpiled by simple command on cmd or git bash
```
mvn compile

```
# Run 
To run the maven project there are following commands
```
mvn compile exec:java -Dexec.mainClass="com.databases.App"

```
it will not create any jar file instead it just run the main class of your project
```
mvn install

```
it create the jar file with your target folder which contain all class files in it.

You can run just tests with:
```
mvn test

```
Another way to do compile and run the project is to use the [javafx-maven-plugin](https://github.com/javafx-maven-plugin/javafx-maven-plugin). You'll have to include that in the pom.xml. This project includes it, just to show you where to put it.

Then you can compile and run using:
```
mvn jfx:run

```
# Exe file
To make exe file you have to import the native plug in from [javafx-maven-plugin](https://github.com/javafx-maven-plugin/javafx-maven-plugin)
then run following command:
```
mvn jfx:native

```
# Dependencies
This projects connects to a Microsoft SQL Server and fetches data. The JDBC Driver for that is available in the maven repository.
To install it, I just had to add it as a runtime dependency in pom.xml.

# Project Structure
The project structure is really simple. Maven does most of the scaffolding. Then you need 5 directories inside your main pacakge.
* config — for private static final things
* controllers — JavaFX controllers
* dao — Data Access Objects. Takes care of the nitty gritty of SQL Queries. 
* models — for the M in MVC. Represents Entities in your database. Or not, up to you.
* services — for SQL connections and other services
And 3 directories inside your resources directory (fxml, css and images), which you do have to create. Although maven takes care of copying the resources to the target directory itself.
