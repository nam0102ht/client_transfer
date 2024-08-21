package com.ntnn.config;

import com.ntnn.wsld.Document;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JaxbConfiguration {
    @Bean
    public JAXBContext getJaxbContext() throws JAXBException {
        return JAXBContext.newInstance(Document.class);
    }
}
