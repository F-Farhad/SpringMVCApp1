package ru.alishev.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};    //указываем где находится Spring конфигурация
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};  // все HTTP запросы от пользователя посылаем на DispatcherServlet
    }
}
