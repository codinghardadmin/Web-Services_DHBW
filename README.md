# quarkus-keepyourday project

From helloworld quarkus project:

Created via:
mvn io.quarkus:quarkus-maven-plugin:1.1.1.Final:create \
  -DprojectGroupId=org.dhbw.mosbach.ai -DprojectArtifactId=quarkus-helloworld \
  -DclassName="org.dhbw.mosbach.ai.hello.HelloWorld" -Dpath="/hello"


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

For debugging, see
https://developers.redhat.com/blog/2019/05/09/create-your-first-quarkus-project-with-eclipse-ide-red-hat-codeready-studio/

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `quarkus-keepyourday-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-keepyourday-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/quarkus-keepyourday-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .
