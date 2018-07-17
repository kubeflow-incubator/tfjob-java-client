package org.kubeflow.client.examples;

import io.kubernetes.client.models.*;
import java.io.IOException;
import java.util.*;
import org.kubeflow.client.ApiClient;
import org.kubeflow.client.ApiException;
import org.kubeflow.client.Configuration;
import org.kubeflow.client.apis.KubeflowOrgV1alpha2Api;
import org.kubeflow.client.models.V1alpha2TFJob;
import org.kubeflow.client.models.V1alpha2TFJobList;
import org.kubeflow.client.models.V1alpha2TFJobSpec;
import org.kubeflow.client.models.V1alpha2TFReplicaSpec;
import org.kubeflow.client.util.Config;

/**
 * A simple example of how to use the Java API
 *
 * <p>
 *
 * <p>Easiest way to run this: mvn exec:java -Dexec.mainClass="org.kubeflow.client.examples.Example"
 *
 * <p>
 *
 * <p>From inside $REPO_DIR/examples
 */
public class Example {
  public static void main(String[] args) throws IOException, ApiException {
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    KubeflowOrgV1alpha2Api api = new KubeflowOrgV1alpha2Api();

    V1alpha2TFJobList list = api.listTFJobForAllNamespaces(null, null, null, null, null, null, null, null, null);
    for (V1alpha2TFJob item : list.getItems()) {
      System.out.println(item.getMetadata().getName());
    }
  }
}
