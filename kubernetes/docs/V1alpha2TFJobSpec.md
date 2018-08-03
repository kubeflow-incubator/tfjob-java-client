
# V1alpha2TFJobSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cleanPodPolicy** | **String** | CleanPodPolicy defines the policy to kill pods after TFJob is succeeded. Default to Running. |  [optional]
**tfReplicaSpecs** | [**Map&lt;String, V1alpha2TFReplicaSpec&gt;**](V1alpha2TFReplicaSpec.md) | TFReplicaSpecs is map of TFReplicaType and TFReplicaSpec specifies the TF replicas to run. For example,   {     \&quot;PS\&quot;: TFReplicaSpec,     \&quot;Worker\&quot;: TFReplicaSpec,   } | 
**ttlSecondsAfterFinishing** | **Integer** | TTLSecondsAfterFinished is the TTL to clean up tf-jobs (temporary before kubernetes adds the cleanup controller). It may take extra ReconcilePeriod seconds for the cleanup, since reconcile gets called periodically. Default to infinite. |  [optional]



