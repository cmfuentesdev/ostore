package es.ostore.web.rest.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import es.ostore.web.rest.config.annotations.RequestJsonMethodProcessor;

@Configuration
public class REST_Config implements WebMvcConfigurer{

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new RequestJsonMethodProcessor());
	}
	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("es.wshop.web.rest"))
//				.build().apiInfo(apiInfo());
//	}
//	
//	@Bean ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("API para tienda online")
//				.description("Prueba de api para tiendecilla online")
//				.version("1.0")
//				.contact(new Contact("Carlos", "www.serbatic.es", "xxxxxxx@ostore.es")).build();
//	}
}
