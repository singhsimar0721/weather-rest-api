package com.service.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.weather.exception.WeatherAPIErrorHandler;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Simarpreet Singh, created on 10 April 2020.
 * 
 *	Spring Boot: REST Web Service integrated with Open Weather API {https://openweathermap.org/current},
 *	provides Weather information based on City, Country, ISO 3166 Code or Latitude-Longitude.
 *
 *	Application Initiator.
 */
@EnableSwagger2
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class WeatherRestApiApplication {

	/**
	 * Startup method to launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeatherRestApiApplication.class, args);
	}

	/**
	 * Creates Rest Template Client object: To make third party Rest API calls from application.
	 * @param builder
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new WeatherAPIErrorHandler()).build();
	}

	/**
	 * Create Docket Object, To customize the documentation details on Swagger UI.
	 * @return Docket 
	 */
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
				.build()
				.apiInfo(generateApiInfo());		
	}

	/**
	 * Create ApiInfo object, To display API information on Swagger UI.
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private ApiInfo generateApiInfo()
	{
		return new ApiInfo("Weather REST Services Console", "Users can test Weather REST APIs.", "Version 1.0 - mw",
				"urn:tos", "career@intigral.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}

}
