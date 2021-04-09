# SampleControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sayHello**](SampleControllerApi.md#sayHello) | **GET** /hello | 
[**sayHelloPost**](SampleControllerApi.md#sayHelloPost) | **POST** /hello | 



## sayHello

> String sayHello(name)



this is used to get a greeting message from the server

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SampleControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SampleControllerApi apiInstance = new SampleControllerApi(defaultClient);
        String name = "name_example"; // String | 
        try {
            String result = apiInstance.sayHello(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SampleControllerApi#sayHello");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | you did something wrong |  -  |
| **200** | everything is ok when getting the message |  -  |


## sayHelloPost

> String sayHelloPost(body)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SampleControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SampleControllerApi apiInstance = new SampleControllerApi(defaultClient);
        String body = "body_example"; // String | 
        try {
            String result = apiInstance.sayHelloPost(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SampleControllerApi#sayHelloPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

