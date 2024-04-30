package org.integrador.apadrinhacao.common.modelmapperconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModel(){
        return new ModelMapper();
    }

}
