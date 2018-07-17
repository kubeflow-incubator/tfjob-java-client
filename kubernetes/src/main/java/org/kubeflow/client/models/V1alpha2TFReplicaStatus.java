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


package org.kubeflow.client.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TFReplicaStatus represents the current observed state of the TFReplica.
 */
@ApiModel(description = "TFReplicaStatus represents the current observed state of the TFReplica.")

public class V1alpha2TFReplicaStatus {
  @SerializedName("active")
  private Integer active = null;

  @SerializedName("failed")
  private Integer failed = null;

  @SerializedName("succeeded")
  private Integer succeeded = null;

  public V1alpha2TFReplicaStatus active(Integer active) {
    this.active = active;
    return this;
  }

   /**
   * The number of actively running pods.
   * @return active
  **/
  @ApiModelProperty(value = "The number of actively running pods.")
  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }

  public V1alpha2TFReplicaStatus failed(Integer failed) {
    this.failed = failed;
    return this;
  }

   /**
   * The number of pods which reached phase Failed.
   * @return failed
  **/
  @ApiModelProperty(value = "The number of pods which reached phase Failed.")
  public Integer getFailed() {
    return failed;
  }

  public void setFailed(Integer failed) {
    this.failed = failed;
  }

  public V1alpha2TFReplicaStatus succeeded(Integer succeeded) {
    this.succeeded = succeeded;
    return this;
  }

   /**
   * The number of pods which reached phase Succeeded.
   * @return succeeded
  **/
  @ApiModelProperty(value = "The number of pods which reached phase Succeeded.")
  public Integer getSucceeded() {
    return succeeded;
  }

  public void setSucceeded(Integer succeeded) {
    this.succeeded = succeeded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha2TFReplicaStatus v1alpha2TFReplicaStatus = (V1alpha2TFReplicaStatus) o;
    return Objects.equals(this.active, v1alpha2TFReplicaStatus.active) &&
        Objects.equals(this.failed, v1alpha2TFReplicaStatus.failed) &&
        Objects.equals(this.succeeded, v1alpha2TFReplicaStatus.succeeded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, failed, succeeded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha2TFReplicaStatus {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
    sb.append("    succeeded: ").append(toIndentedString(succeeded)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

