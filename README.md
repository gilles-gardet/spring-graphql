# GRAPHQL
Using the [graphiql](http://localhost:8080/graphiql?path=/graphql) we can perform queries against the database.
## Find the entities
To request all the entities:
```graphql
query {
   getTasks {
    id
    content
    done
  }
}
```
To request a single identified entity:
```graphql
query {
    getTask(id: "0875b7f3-a2cc-402b-a73d-c3fd3beffe99") {
        id
        content
        done
    }
}
```
## Create, update or delete the entities
To create a new entity:
```graphql
mutation {
  createTask(content: "Sortir les poubelles") {
    id
  }
}
```
To update an existing entity:
```graphql
mutation {
  updateTask(id: "0875b7f3-a2cc-402b-a73d-c3fd3beffe99", content:"Tondre la pelouse", done: true) {
    id
    content
    done
  }
}
```
To delete an entity:
```graphql
mutation {
  deleteTask(id: "0875b7f3-a2cc-402b-a73d-c3fd3beffe99")
}
```
# GRAALVM
Build a native image with [GraalVM](https://graalvm.github.io/native-build-tools/latest/graalvm-setup.html) which can be downloaded using this curl command:
```shell
bash <(curl -sL https://get.graalvm.org/jdk)
```
Once downloaded and the path to GraalVM setted using for example (to adapt):
```shell
export GRAALVM_HOME="/Users/gilles/graalvm-ce-java17-22.3.1/Contents/Home"
```
then on the repository the following command should build a native image:
```shell
./gradlew nativeCompile
```
