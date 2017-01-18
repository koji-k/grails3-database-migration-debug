This repository is a sample that to check the problem about Grails database migration plugin.  
Grails version is 3.2.4.

For detail, please refer to this issue
[dbm-gorm-diff fails after the second time.](https://github.com/grails-plugins/grails-database-migration/issues/115)

This sample application uses PostgreSQL9.3.  
You can run PostgreSQL 9.3 on Docker quickly with following commands. 

```
# Run and Install PostgreSQL 9.3 instance.
docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres:9.3.15

# Create sample database. please input "password" as password when psql asks passowrd you.
[user:/]$ docker run -it --rm --link some-postgres:postgres postgres:9.3.15 psql -c 'CREATE DATABASE migrationtest' -h postgres -U postgres
Password for user postgres: [PLEASE ENTER HERE "password"]
CREATE DATABASE
[user:/]$ 
```

Then, pull this repository and execute followings.

```
# create tables for migration plugin
grails dbm-update

# create changeset first time and migrate.
dbm-gorm-diff 1.groovy --add
dbm-update

# execute dbm-gorm-diff again. THIS
dbm-gorm-diff
```

show following error message.

```
Command execution error: liquibase.command.CommandExecutionException: java.lang.ClassCastException: liquibase.statement.DatabaseFunction cannot be cast to java.lang.Integer
:dbmGormDiff FAILED

FAILURE: Build failed with an exception.

```