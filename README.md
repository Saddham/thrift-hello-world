# Thrift Java server & NodeJS client

### Generating Java files 

```
mvn clean install
```

### Generating NodeJS files

```
thrift -r --gen js:node ./src/main/thrift/UserAPIs.thrift
```

### Start Java Thrift server 

```
mvn exec:java -Dexec.mainClass=com.users.Main
```

### Run the NodeJS client

```
node js-client.js
```