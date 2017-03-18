package com.web.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class WebConfiguration extends WebMvcConfigurerAdapter {

//    @Bean
//    public AddressDAO getAddressDAO(){
//        return new AddressDAOImpl();
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources*//**").addResourceLocations("/resources/");
//    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SessionFactory getSessionFactory(){

        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }









    /*
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306");
        prop.setProperty("hibernate.connection.username","root");
        prop.setProperty("hibernate.connection.password","");
        prop.setProperty("hibernate.dialect","");
        prop.setProperty("show_sql","true");

     */

}
