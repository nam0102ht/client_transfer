package com.ntnn.helper;

import com.ntnn.dto.GenericSingleRestResponse;
import com.ntnn.wsld.Document;
import com.ntnn.wsld.GroupHeader70;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component
@RequiredArgsConstructor
public class XmlParser {
  private final JAXBContext context;

  public Document transformXmlToObject(String xmlDocument) throws JAXBException {
    Unmarshaller unmarshaller = context.createUnmarshaller();
    JAXBElement<Document> jaxbElement = (JAXBElement) unmarshaller.unmarshal(new StringReader(xmlDocument));
    return jaxbElement.getValue();
  }

  public GenericSingleRestResponse prepareResponseDocument(final Document document) {
    GenericSingleRestResponse genericSingleRestResponse = new GenericSingleRestResponse();
    final GroupHeader70 groupHeader = new GroupHeader70();
    BeanUtils.copyProperties(document.getFIToFICstmrCdtTrf().getGrpHdr(), groupHeader);
    genericSingleRestResponse.setGrpHdr(groupHeader);
    return genericSingleRestResponse;
  }
}
