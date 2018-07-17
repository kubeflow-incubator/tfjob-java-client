package org.kubeflow.client;

import io.kubernetes.client.models.V1DeleteOptions;
import io.kubernetes.client.models.V1Status;
import java.util.ArrayList;
import java.util.List;
import org.kubeflow.client.apis.KubeflowOrgV1alpha2Api;
import org.kubeflow.client.model.Job;
import org.kubeflow.client.model.JobConstants;
import org.kubeflow.client.models.V1alpha2TFJob;
import org.kubeflow.client.models.V1alpha2TFJobList;

public class KubeflowClient {
  private KubeflowOrgV1alpha2Api api;
  private String defaultNamespace = JobConstants.DEFAULT_NAMESPACE;

  KubeflowClient(KubeflowOrgV1alpha2Api api) {
    this.api = api;
  }

  KubeflowClient(KubeflowOrgV1alpha2Api api, String defaultNamespace) {
    this.api = api;
    this.defaultNamespace = defaultNamespace;
  }

  public String getDefaultNamespace() {
    return this.defaultNamespace;
  }

  /**
   * create a job
   *
   * @param job (required)
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public void submitJob(Job job) throws ApiException {
    submitJob(job, this.defaultNamespace);
  }

  /**
   * create a job
   *
   * @param job (required)
   * @param namespace object name and auth scope, such as for teams and projects
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public void submitJob(Job job, String namespace) throws ApiException {
    V1alpha2TFJob tfjob = job.getTfjob();
    job.setTfjob(this.api.createNamespacedTFJob(namespace, tfjob, "true"));
  }

  /**
   * list all jobs with default parameters
   *
   * @return list of job
   * @throws ApiException
   */
  public List<Job> listJobs() throws ApiException {
    return listJobs(this.defaultNamespace);
  }

  /**
   * list all jobs with given namespace
   *
   * @param namespace object name and auth scope, such as for teams and projects (optional, default
   *     to 'default')
   * @return list of job
   * @throws ApiException
   */
  public List<Job> listJobs(String namespace) throws ApiException {
    return listJobs(namespace, null, null, null);
  }

  /**
   * list all jobs with given requirements
   *
   * @param namespace object name and auth scope, such as for teams and projects (optional, default
   *     to 'default')
   * @param labelSelector A selector to restrict the list of returned objects by their labels.
   *     Defaults to everything. (optional)
   * @param limit limit is a maximum number of responses to return for a list call. (optional)
   * @param includeUninitialized If true, partially initialized resources are included in the
   *     response. (optional)
   * @return list of job
   */
  public List<Job> listJobs(
      String namespace, String labelSelector, Integer limit, Boolean includeUninitialized)
      throws ApiException {
    V1alpha2TFJobList list =
        this.api.listNamespacedTFJob(
            namespace,
            null,
            null,
            null,
            includeUninitialized,
            labelSelector,
            limit,
            null,
            null,
            null);
    List<Job> jobs = new ArrayList<Job>();

    for (V1alpha2TFJob tfjob : list.getItems()) {
      jobs.add(new Job(tfjob));
    }

    return jobs;
  }

  /**
   * delete a job
   *
   * @param name name of job
   * @return success or not
   * @throws ApiException
   */
  public boolean deleteJob(String name) throws ApiException {
    return deleteJob(name, this.defaultNamespace);
  }

  /**
   * delete a job
   *
   * @param name name of this job
   * @param namespace namespace of this job
   * @return success or not
   * @throws ApiException
   */
  public boolean deleteJob(String name, String namespace) throws ApiException {
    V1DeleteOptions options = new V1DeleteOptions();
    V1Status status =
        this.api.deleteNamespacedTFJob(name, namespace, options, null, null, null, null);
    return status.getStatus().equals("success");
  }

  /**
   * update a job
   *
   * @param name name of this job
   * @param job new configuration of this job
   * @throws ApiException
   */
  public void updateJob(String name, Job job) throws ApiException {
    updateJob(name, this.defaultNamespace, job);
  }

  /**
   * update a job
   *
   * @param name name of this job
   * @param namespace namespace of this job
   * @param job new configuration of this job
   * @throws ApiException
   */
  public void updateJob(String name, String namespace, Job job) throws ApiException {
    job.setTfjob(this.api.patchNamespacedTFJob(name, namespace, job, null));
  }
}
