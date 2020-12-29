package DuAn2.configuration;



import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class ValidateConfiguration implements WebMvcConfigurer {

	@Bean
	 public MessageSource messageSource() {
	 ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
	 resourceBundleMessageSource.setBasename("messages");
	 return resourceBundleMessageSource;
	 }

	
}
