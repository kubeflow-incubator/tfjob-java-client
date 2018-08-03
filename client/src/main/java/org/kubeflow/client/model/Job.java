package org.kubeflow.client.model;

import io.kubernetes.client.models.*;
import org.kubeflow.client.models.V1alpha2TFJob;
import org.kubeflow.client.models.V1alpha2TFJobSpec;

public class Job {
  private V1alpha2TFJob tfjob;

  public Job() {
    this.tfjob =
        new V1alpha2TFJob()
            .apiVersion(JobConstants.KUBEFLOW_API_VERSION)
            .kind(JobConstants.KUBEFLOW_JOB_KIND)
            .spec(new V1alpha2TFJobSpec())
            .metadata(new V1ObjectMeta());
  }

  public Job(V1alpha2TFJob tfjob) {
    this.tfjob = tfjob;
  }

  public void setTfjob(V1alpha2TFJob tfjob) {
    this.tfjob = tfjob;
  }

  public Job name(String name) {
    this.tfjob.getMetadata().name(name);
    return this;
  }

  public String getName() {
    return this.tfjob.getMetadata().getName();
  }

  public Job cleanupPolicy(String cleanupPolicy) {
    this.tfjob.getSpec().cleanPodPolicy(cleanupPolicy);
    return this;
  }

  public String getCleanupPolicy() {
    return this.tfjob.getSpec().getCleanPodPolicy();
  }

  public Job ttlSecondsAfterFinishing(int ttl) {
      this.tfjob.getSpec().ttlSecondsAfterFinishing(ttl);
      return this;
  }

  public int getTtlSecondsAfterFinishing() {
      return this.tfjob.getSpec().getTtlSecondsAfterFinishing();
  }

  public Job ps(TFReplica replica) {
    this.tfjob
        .getSpec()
        .putTfReplicaSpecsItem(JobConstants.KUBEFLOW_PS_REPLICA_NAME, replica.getSpec());
    return this;
  }

  public TFReplica getPs() {
    return new TFReplica(
        this.tfjob.getSpec().getTfReplicaSpecs().get(JobConstants.KUBEFLOW_PS_REPLICA_NAME));
  }

  public Job worker(TFReplica replica) {
    this.tfjob
        .getSpec()
        .putTfReplicaSpecsItem(JobConstants.KUBEFLOW_WORKER_REPLICA_NAME, replica.getSpec());
    return this;
  }

  public TFReplica getWorker() {
    return new TFReplica(
        this.tfjob.getSpec().getTfReplicaSpecs().get(JobConstants.KUBEFLOW_WORKER_REPLICA_NAME));
  }

  public V1alpha2TFJob getTfjob() {
    return this.tfjob;
  }
}
