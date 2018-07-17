package org.kubeflow.client;

import static junit.framework.TestCase.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.kubeflow.client.model.JobConstants;

public class TestKubeflowClientFactory {
  private String kubeconfigPath = "kubeconfig";

  @Test
  public void testNewInstanceWithDefault() throws IOException {
    KubeflowClient client = KubeflowClientFactory.newInstance();
    assertEquals(client.getDefaultNamespace(), JobConstants.DEFAULT_NAMESPACE);
  }

  @Test
  public void testNewInstanceWithKubeconfig() throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(kubeconfigPath).getFile());
    KubeflowClient client = KubeflowClientFactory.newInstanceFromConfig(file.getAbsolutePath());

    String expectedNamespace = "new-default";
    assertEquals(client.getDefaultNamespace(), expectedNamespace);
  }
}
