package org.kubeflow.client.util.credentials;

import org.kubeflow.client.ApiClient;
import org.kubeflow.client.util.ClientBuilder;

/**
 * Allows the implementation of different authentication mechanisms for the Kubernetes API.
 *
 * @see ClientBuilder#setAuthentication(Authentication)
 */
public interface Authentication {

  void provide(ApiClient client);
}
