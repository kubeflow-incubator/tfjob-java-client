package org.kubeflow.client.examples;

import java.util.List;
import org.kubeflow.client.KubeflowClient;
import org.kubeflow.client.KubeflowClientFactory;
import org.kubeflow.client.model.Job;
import org.kubeflow.client.model.TFReplica;

public class Example {
  public static void main(String[] args) {
    try {
      KubeflowClient client =
          KubeflowClientFactory.newInstanceFromConfig("/home/mofeng.cj/kubeconfig");

      TFReplica ps =
          new TFReplica()
              .replicas(1)
              .cpu(1.0)
              .memory(1024.0)
              .image("registry.cn-hangzhou.aliyuncs.com/jetmuffin/word2vec_kubeflow");
      TFReplica worker =
          new TFReplica()
              .replicas(1)
              .cpu(2.0)
              .memory(2048.0)
              .image("registry.cn-hangzhou.aliyuncs.com/jetmuffin/word2vec_kubeflow");
      Job job = new Job().name("test").ps(ps).worker(worker).cleanupPolicy("running");
      client.submitJob(job);

      List<Job> jobs = client.listJobs();
      for (Job j : jobs) {
        System.out.println(j);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
