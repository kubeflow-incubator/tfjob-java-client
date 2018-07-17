
# V1alpha2TFJobStatus

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**completionTime** | [**DateTime**](DateTime.md) | Represents time when the TFJob was completed. It is not guaranteed to be set in happens-before order across separate operations. It is represented in RFC3339 form and is in UTC. |  [optional]
**conditions** | [**List&lt;V1alpha2TFJobCondition&gt;**](V1alpha2TFJobCondition.md) | Conditions is an array of current observed TFJob conditions. | 
**lastReconcileTime** | [**DateTime**](DateTime.md) | Represents last time when the TFJob was reconciled. It is not guaranteed to be set in happens-before order across separate operations. It is represented in RFC3339 form and is in UTC. |  [optional]
**startTime** | [**DateTime**](DateTime.md) | Represents time when the TFJob was acknowledged by the TFJob controller. It is not guaranteed to be set in happens-before order across separate operations. It is represented in RFC3339 form and is in UTC. |  [optional]
**tfReplicaStatuses** | [**Map&lt;String, V1alpha2TFReplicaStatus&gt;**](V1alpha2TFReplicaStatus.md) | TFReplicaStatuses is map of TFReplicaType and TFReplicaStatus, specifies the status of each TFReplica. | 



