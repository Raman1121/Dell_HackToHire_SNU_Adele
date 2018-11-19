package formSubmit;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {
	 @Bean
	  public ObjectMapper getObjectMapper() {
	    return new ObjectMapper();
	  }

	  @Bean
	  public MappingJackson2HttpMessageConverter messageConverter() {
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setObjectMapper(getObjectMapper());
	    return converter;
	  }

	  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    converters.add(messageConverter());
	    addDefaultHttpMessageConverters(converters);
	  }
}
