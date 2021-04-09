package com.revature;



import org.openapitools.client.ApiClient;
import org.openapitools.client.api.SampleControllerApi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("org.openapitools")
public class Driver {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Driver.class);
		ApiClient defaultClient = appContext.getBean(ApiClient.class);
		defaultClient.setBasePath("http://localhost:8080");

		SampleControllerApi apiInstance = new SampleControllerApi(defaultClient);
		String name = "nick"; // String |
		try {
			String result = apiInstance.sayHello(name);
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Exception when calling SampleControllerApi#sayHello");
			/*
			 * System.err.println("Status code: " + e.getCode());
			 * System.err.println("Reason: " + e.getResponseBody());
			 * System.err.println("Response headers: " + e.getResponseHeaders());
			 */
			e.printStackTrace();
		}

	}

}
