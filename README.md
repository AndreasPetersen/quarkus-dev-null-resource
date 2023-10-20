# quarkus-dev-null-resource

To reproduce:

```
cd my-app
quarkus dev
```

then in another terminal:

```
curl localhost:8080/hello
```

observe an exception.

On the other hand, running tests and running the build jar works:

```
./gradlew test
```

```
./gradlew build
java -jar build/quarkus-app/quarkus-run.jar
```

followed by a REST request:

```
curl localhost:8080/hello
```
