package org.kubeflow.client.model;

import io.kubernetes.client.custom.Quantity;
import io.kubernetes.client.models.V1Container;
import io.kubernetes.client.models.V1PodSpec;
import io.kubernetes.client.models.V1PodTemplateSpec;
import io.kubernetes.client.models.V1ResourceRequirements;
import java.util.Arrays;
import org.kubeflow.client.models.V1alpha2TFReplicaSpec;
import org.kubeflow.client.util.JobUtil;

public class TFReplica {
  private V1alpha2TFReplicaSpec spec;

  public TFReplica() {
    V1PodSpec podSpec = new V1PodSpec();
    V1Container container = new V1Container().name(JobConstants.KUBEFLOW_CONTAINER_NAME);
    container.resources(new V1ResourceRequirements());
    podSpec.addContainersItem(container);
    this.spec = new V1alpha2TFReplicaSpec().template(new V1PodTemplateSpec().spec(podSpec));
  }

  public TFReplica(V1alpha2TFReplicaSpec spec) {
    this.spec = spec;
  }

  public TFReplica image(String image) {
    for (V1Container container : this.spec.getTemplate().getSpec().getContainers()) {
      if (container.getName().equals(JobConstants.KUBEFLOW_CONTAINER_NAME)) {
        container.setImage(image);
      }
    }
    return this;
  }

  public String getImage() {
    return this.spec.getTemplate().getSpec().getContainers().get(0).getImage();
  }

  public TFReplica replicas(int replica) {
    this.spec.setReplicas(replica);
    return this;
  }

  public int getReplicas() {
    return this.spec.getReplicas();
  }

  public TFReplica command(String command) {
    if (command != null && command.length() > 0) {
      String[] commands = command.split("\\s+");
      this.spec.getTemplate().getSpec().getContainers().get(0).setCommand(Arrays.asList(commands));
    }
    return this;
  }

  public String getCommand() {
    return JobUtil.joinCommands(
        this.spec.getTemplate().getSpec().getContainers().get(0).getCommand());
  }

  public TFReplica cpu(Double cpu) {
    this.spec
        .getTemplate()
        .getSpec()
        .getContainers()
        .get(0)
        .getResources()
        .putRequestsItem("cpu", new Quantity(Double.toString(cpu)));
    return this;
  }

  public Double getCpu() {
    return this.spec
        .getTemplate()
        .getSpec()
        .getContainers()
        .get(0)
        .getResources()
        .getRequests()
        .get("cpu")
        .getNumber()
        .toBigInteger()
        .doubleValue();
  }

  public TFReplica memory(Double memory) {
    this.spec
        .getTemplate()
        .getSpec()
        .getContainers()
        .get(0)
        .getResources()
        .putRequestsItem("memory", new Quantity(Double.toString(memory)));
    return this;
  }

  public Double getMemory() {
    return this.spec
        .getTemplate()
        .getSpec()
        .getContainers()
        .get(0)
        .getResources()
        .getRequests()
        .get("memory")
        .getNumber()
        .toBigInteger()
        .doubleValue();
  }

  public V1alpha2TFReplicaSpec getSpec() {
    return this.spec;
  }
}
