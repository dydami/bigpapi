package app.student.com.config;

import javax.servlet.ServletContext;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
	public class ThymeleafConfig {

	

	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	    }

	    @Bean
	    public SpringResourceTemplateResolver templateResolver() {
	        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setPrefix("classpath:/templates/");
	        templateResolver.setSuffix(".html");
	        return templateResolver;
	    }

	    @Bean
	    public ThymeleafViewResolver thymeleafViewResolver() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        return viewResolver;
	    }
	    // other Thymeleaf-related beans and configurations go here
	    
	}


