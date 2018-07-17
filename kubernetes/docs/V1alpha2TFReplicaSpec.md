
# V1alpha2TFReplicaSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**replicas** | **Integer** | Replicas is the desired number of replicas of the given template. If unspecified, defaults to 1. |  [optional]
**restartPolicy** | **String** | Restart policy for all TFReplicas within the TFJob. One of Always, OnFailure, Never and ExitCode. Default to Never. |  [optional]
**template** | [**V1PodTemplateSpec**](V1PodTemplateSpec.md) | Template is the object that describes the pod that will be created for this TFReplica. RestartPolicy in PodTemplateSpec will be overide by RestartPolicy in TFReplicaSpec |  [optional]



