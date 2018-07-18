package org.kubeflow.client.model;

import static org.junit.Assert.*;

import io.kubernetes.client.models.V1Container;
import io.kubernetes.client.models.V1EnvVar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.kubeflow.client.models.V1alpha2TFJob;
import org.kubeflow.client.models.V1alpha2TFReplicaSpec;

public class JobTest {

  @Test
  public void testBuild() {
    TFReplica ps =
        new TFReplica()
            .replicas(1)
            .cpu(0.5)
            .memory(1024.0)
            .image("tensorflow:1.7.0")
            .command("python test.py")
            .args("--train_tfrecords=train --test_tfrecords=test")
            .env("RESOURCE_PATH", "file:///data");
    TFReplica worker =
        new TFReplica()
            .replicas(1)
            .cpu(0.5)
            .memory(1024.0)
            .image("tensorflow:1.7.0")
            .command("python test.py")
            .args("--train_tfrecords=train --test_tfrecords=test")
            .env("RESOURCE_PATH", "file:///data");
    Job job = new Job().name("test_job").ps(ps).worker(worker);

    V1alpha2TFJob tfjob = job.getTfjob();

    assertEquals(tfjob.getMetadata().getName(), job.getName());
    assert tfjob.getSpec().getTfReplicaSpecs().containsKey("PS");
    assert tfjob.getSpec().getTfReplicaSpecs().containsKey("Worker");

    V1alpha2TFReplicaSpec psSpec = tfjob.getSpec().getTfReplicaSpecs().get("PS");

    boolean found = false;
    for (V1Container container : psSpec.getTemplate().getSpec().getContainers()) {
      if (container.getName().equals(JobConstants.KUBEFLOW_CONTAINER_NAME)) {
        found = true;
        assertEquals(container.getImage(), "tensorflow:1.7.0");
      }
    }
    assert found;

    assertEquals(psSpec.getReplicas().intValue(), job.getPs().getReplicas());

    assert psSpec.getTemplate().getSpec().getContainers().size() > 0;
    V1Container container = psSpec.getTemplate().getSpec().getContainers().get(0);

    assertEquals(container.getImage(), job.getPs().getImage());
    assertEquals(container.getCommand().size(), 2);
    assertEquals(container.getCommand().get(0), "python");
    assertEquals(container.getCommand().get(1), "test.py");

    assertEquals(container.getArgs().size(), 2);
    assertEquals(container.getArgs().get(0), "--train_tfrecords=train");

    List<V1EnvVar> envVar = container.getEnv();
    Map<String, String> envs = new HashMap<>();
    for (V1EnvVar item : envVar) {
      envs.put(item.getName(), item.getValue());
    }
    assert envs.containsKey("RESOURCE_PATH");
    assertEquals(envs.get("RESOURCE_PATH"), "file:///data");
  }
}
