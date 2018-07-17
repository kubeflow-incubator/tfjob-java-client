
# V1alpha2TFJob

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**apiVersion** | **String** | APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources |  [optional]
**kind** | **String** | Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#types-kinds |  [optional]
**metadata** | [**V1ObjectMeta**](V1ObjectMeta.md) | Standard object&#39;s metadata. |  [optional]
**spec** | [**V1alpha2TFJobSpec**](V1alpha2TFJobSpec.md) | Specification of the desired behavior of the TFJob. |  [optional]
**status** | [**V1alpha2TFJobStatus**](V1alpha2TFJobStatus.md) | Most recently observed status of the TFJob. This data may not be up to date. Populated by the system. Read-only. |  [optional]



