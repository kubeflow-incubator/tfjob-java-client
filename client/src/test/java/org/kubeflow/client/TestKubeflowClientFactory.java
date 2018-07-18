package org.kubeflow.client;

import static junit.framework.TestCase.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import org.kubeflow.client.model.JobConstants;
import org.kubeflow.client.util.KubeConfig;

public class TestKubeflowClientFactory {
  private String kubeconfigPath = "kubeconfig";

  @Test
  public void testNewInstanceWithDefault() throws IOException {
    KubeflowClient client = KubeflowClientFactory.newInstance();
    KubeConfig kubeConfig;
    String kubeConfigPath = System.getenv("KUBECONFIG");
    if (kubeConfigPath != null) {
      kubeConfig = KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath));
      assertEquals(kubeConfig.getNamespace(), client.getDefaultNamespace());
      return;
    } else {
      File config = new File(new File(System.getenv("HOME"), ".kube"), "config");
      if (config.exists()) {
        kubeConfig = KubeConfig.loadKubeConfig(new FileReader(config));
        assertEquals(kubeConfig.getNamespace(), client.getDefaultNamespace());
        return;
      }
    }

    assertEquals(client.getDefaultNamespace(), JobConstants.DEFAULT_NAMESPACE);
  }

  @Test
  public void testNewInstanceWithKubeconfig() throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(kubeconfigPath).getFile());
    System.out.println(file.getAbsolutePath());
    KubeflowClient client = KubeflowClientFactory.newInstanceFromConfig(file.getAbsolutePath());

    String expectedNamespace = "new-default";
    assertEquals(client.getDefaultNamespace(), expectedNamespace);
  }
}
