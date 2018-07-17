package org.kubeflow.client;

import java.io.*;
import org.kubeflow.client.apis.KubeflowOrgV1alpha2Api;
import org.kubeflow.client.model.JobConstants;
import org.kubeflow.client.util.Config;
import org.kubeflow.client.util.KubeConfig;

public class KubeflowClientFactory {
  private static KubeflowClient newInstance(ApiClient client, String defaultNamespace) {
    Configuration.setDefaultApiClient(client);
    KubeflowOrgV1alpha2Api api = new KubeflowOrgV1alpha2Api(client);
    return new KubeflowClient(api, defaultNamespace);
  }

  /**
   * Kubeflow client creation with default configuration. If environment $KUBECONFIG is defined, use
   * that config file. If $HOME/.kube/config can be found, use that. Default to localhost:8080 as
   * last resort.
   *
   * @return The Kubeflow client given the previously described rules
   * @throws IOException
   */
  public static KubeflowClient newInstance() throws IOException {
    String kubeConfigPath = System.getenv("KUBECONFIG");
    if (kubeConfigPath != null) {
      File kubeConfig = new File(kubeConfigPath);
      if (kubeConfig.exists()) {
        return newInstanceFromConfig(kubeConfig.getAbsolutePath());
      }
    }

    File config = new File(new File(System.getenv("HOME"), ".kube"), "config");
    if (config.exists()) {
      return newInstanceFromConfig(config.getAbsolutePath());
    }

    ApiClient client = Config.defaultClient();
    return newInstance(client, JobConstants.DEFAULT_NAMESPACE);
  }

  /**
   * Kubeflow client creation with specific KubeConfig file name.
   *
   * @param fileName path of KubeConfig file.
   * @return Kubeflow client
   * @throws IOException
   */
  public static KubeflowClient newInstanceFromConfig(String fileName) throws IOException {
    return newInstanceFromConfig((Reader) (new FileReader(fileName)));
  }

  /**
   * Kubeflow client creation with input stream to read KubeConfig file.
   *
   * @param stream stream to read KubeConfig
   * @return Kubeflow client
   * @throws IOException
   */
  public static KubeflowClient newInstanceFromConfig(InputStream stream) throws IOException {
    return newInstanceFromConfig((Reader) (new InputStreamReader(stream)));
  }

  /**
   * Kubeflow client creation with reader to read KubeConfig file.
   *
   * @param input reader to read KubeConfig file
   * @return Kubeflow client
   * @throws IOException
   */
  public static KubeflowClient newInstanceFromConfig(Reader input) throws IOException {
    return newInstanceFromConfig(KubeConfig.loadKubeConfig(input));
  }

  /**
   * Kubeflow client creation with official KubeConfig object
   *
   * @param config official KubeConfig object
   * @return Kubeflow client
   * @throws IOException
   */
  public static KubeflowClient newInstanceFromConfig(KubeConfig config) throws IOException {
    return newInstance(Config.fromConfig(config), config.getNamespace());
  }
}
