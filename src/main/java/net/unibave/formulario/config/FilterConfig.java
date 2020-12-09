package net.unibave.formulario.config;

import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<SquigglyRequestFilter> squigglyFilterRegister() {
        FilterRegistrationBean<SquigglyRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new SquigglyRequestFilter());
        registration.setOrder(1);
        return registration;
    }
}