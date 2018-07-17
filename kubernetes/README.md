# client-java

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.kubernetes</groupId>
    <artifactId>client-java</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.kubernetes:client-java:1.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/client-java-1.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.kubeflow.client.*;
import org.kubeflow.client.auth.*;
import org.kubeflow.client.models.*;
import org.kubeflow.client.apis.ApisApi;

import java.io.File;
import java.util.*;

public class ApisApiExample {

    public static void main(String[] args) {
        
        ApisApi apiInstance = new ApisApi();
        try {
            V1APIGroupList result = apiInstance.getAPIVersions();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApisApi#getAPIVersions");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApisApi* | [**getAPIVersions**](docs/ApisApi.md#getAPIVersions) | **GET** /apis/ | 
*KubeflowOrgApi* | [**getAPIGroup**](docs/KubeflowOrgApi.md#getAPIGroup) | **GET** /apis/kubeflow.org/ | 
*KubeflowOrgV1alpha2Api* | [**createNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#createNamespacedTFJob) | **POST** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs | 
*KubeflowOrgV1alpha2Api* | [**deleteCollectionNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#deleteCollectionNamespacedTFJob) | **DELETE** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs | 
*KubeflowOrgV1alpha2Api* | [**deleteNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#deleteNamespacedTFJob) | **DELETE** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs/{name} | 
*KubeflowOrgV1alpha2Api* | [**getAPIResources**](docs/KubeflowOrgV1alpha2Api.md#getAPIResources) | **GET** /apis/kubeflow.org/v1alpha2/ | 
*KubeflowOrgV1alpha2Api* | [**listNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#listNamespacedTFJob) | **GET** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs | 
*KubeflowOrgV1alpha2Api* | [**listTFJobForAllNamespaces**](docs/KubeflowOrgV1alpha2Api.md#listTFJobForAllNamespaces) | **GET** /apis/kubeflow.org/v1alpha2/tfjobs | 
*KubeflowOrgV1alpha2Api* | [**patchNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#patchNamespacedTFJob) | **PATCH** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs/{name} | 
*KubeflowOrgV1alpha2Api* | [**readNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#readNamespacedTFJob) | **GET** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs/{name} | 
*KubeflowOrgV1alpha2Api* | [**replaceNamespacedTFJob**](docs/KubeflowOrgV1alpha2Api.md#replaceNamespacedTFJob) | **PUT** /apis/kubeflow.org/v1alpha2/namespaces/{namespace}/tfjobs/{name} | 


## Documentation for Models

 - [V1alpha2TFJob](docs/V1alpha2TFJob.md)
 - [V1alpha2TFJobCondition](docs/V1alpha2TFJobCondition.md)
 - [V1alpha2TFJobList](docs/V1alpha2TFJobList.md)
 - [V1alpha2TFJobSpec](docs/V1alpha2TFJobSpec.md)
 - [V1alpha2TFJobStatus](docs/V1alpha2TFJobStatus.md)
 - [V1alpha2TFReplicaSpec](docs/V1alpha2TFReplicaSpec.md)
 - [V1alpha2TFReplicaStatus](docs/V1alpha2TFReplicaStatus.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



