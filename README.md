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
