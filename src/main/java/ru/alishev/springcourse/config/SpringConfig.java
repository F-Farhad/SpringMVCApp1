package ru.alishev.springcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("ru.alishev.springcourse")
@EnableWebMvc           // данная аннотация равноценная тегу в  <mvc:annotation-driven/> <!--включает необходимые аннотации для Spring MVC приложения-->

/*данный интерфейс реализуется когда мы хотим под себя настроить SpringMVC, в данном случае мы хотим вместо
стандартного шаблонизатора использовать шаблонизатор Thymeleaf*/
public class SpringConfig implements WebMvcConfigurer {

        /*используется для настройки таймлиф*/
        private final ApplicationContext applicationContext;

        @Autowired
        public SpringConfig(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(applicationContext);
            templateResolver.setPrefix("/WEB-INF/views/");  //задаем папку где будут лежать представления
            templateResolver.setSuffix(".html");            //задаем расширения этих представлений
            return templateResolver;
        }

        @Bean
        /*создаем конфигурацию представлений*/
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            templateEngine.setEnableSpringELCompiler(true);
            return templateEngine;
        }

        @Override
        /* это метод интерфейса WebMvcConfigurer, задаем свой шаблонизатор в данном случае таймлиф
        * говорим спрингу что мы хотим его использовать*/
        public void configureViewResolvers(ViewResolverRegistry registry) {
            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
            resolver.setTemplateEngine(templateEngine());
            registry.viewResolver(resolver);
        }
}
