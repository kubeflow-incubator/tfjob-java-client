/*
 * kubeflow
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1alpha2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.kubeflow.client.apis;

import io.kubernetes.client.models.V1DeleteOptions;
import org.kubeflow.client.ApiException;
import io.kubernetes.client.models.V1APIResourceList;
import io.kubernetes.client.models.V1Status;
import org.kubeflow.client.models.V1alpha2TFJob;
import org.kubeflow.client.models.V1alpha2TFJobList;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for KubeflowOrgV1alpha2Api
 */
@Ignore
public class KubeflowOrgV1alpha2ApiTest {

    private final KubeflowOrgV1alpha2Api api = new KubeflowOrgV1alpha2Api();

    
    /**
     * 
     *
     * create a TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createNamespacedTFJobTest() throws ApiException {
        String namespace = null;
        V1alpha2TFJob body = null;
        String pretty = null;
        V1alpha2TFJob response = api.createNamespacedTFJob(namespace, body, pretty);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * delete collection of TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCollectionNamespacedTFJobTest() throws ApiException {
        String namespace = null;
        String pretty = null;
        String _continue = null;
        String fieldSelector = null;
        Boolean includeUninitialized = null;
        String labelSelector = null;
        Integer limit = null;
        String resourceVersion = null;
        Integer timeoutSeconds = null;
        Boolean watch = null;
        V1Status response = api.deleteCollectionNamespacedTFJob(namespace, pretty, _continue, fieldSelector, includeUninitialized, labelSelector, limit, resourceVersion, timeoutSeconds, watch);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * delete a TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteNamespacedTFJobTest() throws ApiException {
        String name = null;
        String namespace = null;
        V1DeleteOptions body = null;
        String pretty = null;
        Integer gracePeriodSeconds = null;
        Boolean orphanDependents = null;
        String propagationPolicy = null;
        V1Status response = api.deleteNamespacedTFJob(name, namespace, body, pretty, gracePeriodSeconds, orphanDependents, propagationPolicy);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * get available resources
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAPIResourcesTest() throws ApiException {
        V1APIResourceList response = api.getAPIResources();

        // TODO: test validations
    }
    
    /**
     * 
     *
     * list or watch objects of kind TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listNamespacedTFJobTest() throws ApiException {
        String namespace = null;
        String pretty = null;
        String _continue = null;
        String fieldSelector = null;
        Boolean includeUninitialized = null;
        String labelSelector = null;
        Integer limit = null;
        String resourceVersion = null;
        Integer timeoutSeconds = null;
        Boolean watch = null;
        V1alpha2TFJobList response = api.listNamespacedTFJob(namespace, pretty, _continue, fieldSelector, includeUninitialized, labelSelector, limit, resourceVersion, timeoutSeconds, watch);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * list or watch objects of kind TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listTFJobForAllNamespacesTest() throws ApiException {
        String _continue = null;
        String fieldSelector = null;
        Boolean includeUninitialized = null;
        String labelSelector = null;
        Integer limit = null;
        String pretty = null;
        String resourceVersion = null;
        Integer timeoutSeconds = null;
        Boolean watch = null;
        V1alpha2TFJobList response = api.listTFJobForAllNamespaces(_continue, fieldSelector, includeUninitialized, labelSelector, limit, pretty, resourceVersion, timeoutSeconds, watch);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * partially update the specified TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchNamespacedTFJobTest() throws ApiException {
        String name = null;
        String namespace = null;
        Object body = null;
        String pretty = null;
        V1alpha2TFJob response = api.patchNamespacedTFJob(name, namespace, body, pretty);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * read the specified TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readNamespacedTFJobTest() throws ApiException {
        String name = null;
        String namespace = null;
        String pretty = null;
        V1alpha2TFJob response = api.readNamespacedTFJob(name, namespace, pretty);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * replace the specified TFJob
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replaceNamespacedTFJobTest() throws ApiException {
        String name = null;
        String namespace = null;
        V1alpha2TFJob body = null;
        String pretty = null;
        V1alpha2TFJob response = api.replaceNamespacedTFJob(name, namespace, body, pretty);

        // TODO: test validations
    }
    
}
