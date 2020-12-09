package net.unibave.formulario.config;

import br.com.ideallsistemas.commons.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Configuration
public class SquigglyConfig {

    @Bean
    @Autowired
    public MappingJackson2HttpMessageConverter objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        Squiggly.init(objectMapper, new RequestSquigglyContextProvider() {
            @Override
            protected String customizeFilter(String filter, HttpServletRequest request, Class beanClass) {
                String DEFAULT_FIELDS = "totalPages,totalElements,last,size,number,sort,numberOfElements,first,empty,";
                if (Objects.nonNull(filter) && !filter.equalsIgnoreCase(StringUtils.EMPTY)) {
                    filter = DEFAULT_FIELDS + "content[" + filter + "]," + filter;
                } else {
                    filter = DEFAULT_FIELDS + "content";
                }
                return filter;
            }
        });
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
