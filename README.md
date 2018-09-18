# HamptonsMagic
Application to help students learn more about their classes

## Setting up the Environment
Follow these steps to setup the environment for recreating this project

### Database backend
Install postgresql with homebrew. Follow [this link](https://www.codementor.io/engineerapart/getting-started-with-postgresql-on-mac-osx-are8jcopb) for a longer tutorial on using PostgreSQL with MacOS. We are using PostgreSQL as our relational database manager because of its high performance, high scalability, and first-class support for
JSON (good alternative to NoSQL databases).
```
brew install postgresql
```
Use the default postgres super user to create a database.
```
createdb [database name]
```
Connect to the database with `psql`.
```
psql [database name]
```

### Connecting to the database
We will be using Java to connect to our PostgreSQL database. The driver can be downloaded [here](https://jdbc.postgresql.org/download.html). After downloading the driver, create
a folder in the project package called `lib` and add the JAR file. To compile and run our
Java files, we will be using `java -cp ...` in order to include the JAR file in the class path.
For example:
```
javac Test.java
java -cp ./:./lib/postgresql-42.2.5.jar Test
```

### 
