# restclient

#### Table of Contents

1. [Overiview](#overview)
2. [Setup](#setup)
3. [Usage](#usage)
4. [Reference](#reference)
5. [Limitations](#limitations)
6. [Development](#development)

## Overview
This app configures a generic REST client using Jersey (Sun) which is responsible for performing calls to a target server.

## Setup
This app depends on:

- Java 6
- Maven 3.2.5

Follow the steps to execute the app:

1. Download the repository:
```
git clone git@github.com:giuliana-bezerra/restclient.git
```
2. Generate the jar with dependencies using Maven:
```
mvn clean
mvn package
```
3. Execute the generated jar:
```
cd target
java -jar restclient-0.0.1-SNAPSHOT-jar-with-dependencies.jar url -u user -p password -j path
```

## Usage
The client can be used either to GET or POST calls. The program
gets 4 parameters:

1. Server URL
2. -u User
3. -p Password
4. -j Path for JSON file

The app supports the following operations:

1. Help option:
```
java -jar restclient-0.0.1-SNAPSHOT-jar-with-dependencies.jar -h
```

2. GET calls without auth:
```
Get URL: java -jar restclient.jar http://localhost:8080
```

3. Get URL using auth: java -jar restclient.jar http://localhost:8080 -u user -p password
```
java -jar restclient.jar http://localhost:8080 -u user -p password
```

4. POST Url without auth:
```
java -jar restclient.jar http://localhost:8080 -j path
```

5. Post URL using auth:
```
java -jar restclient.jar http://localhost:8080 -u user -p password -j path
```

## Reference
See javadoc.

## Limitations
This app only supports GET and POST operations.

## Development
This app implements a base client that allows remote calls to a REST service. Contributions could be adding support to other operations and
authentication strategies.
