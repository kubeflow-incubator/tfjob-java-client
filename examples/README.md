# Running examples

```sh
export REPO_ROOT=/path/to/tfjob-java-client

mvn install -DskipTests

cd ${REPO_ROOT}/examples
mvn package
mvn exec:java -Dexec.mainClass="org.kubeflow.client.examples.Example"
```

