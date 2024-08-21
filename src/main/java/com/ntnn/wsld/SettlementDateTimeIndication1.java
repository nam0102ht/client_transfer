
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SettlementDateTimeIndication1 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="SettlementDateTimeIndication1">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="DbtDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}ISODateTime" minOccurs="0"/>
 *         <element name="CdtDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}ISODateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementDateTimeIndication1", propOrder = {
    "dbtDtTm",
    "cdtDtTm"
})
public class SettlementDateTimeIndication1 {

    @XmlElement(name = "DbtDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dbtDtTm;
    @XmlElement(name = "CdtDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cdtDtTm;

    /**
     * Gets the value of the dbtDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDbtDtTm() {
        return dbtDtTm;
    }

    /**
     * Sets the value of the dbtDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDbtDtTm(XMLGregorianCalendar value) {
        this.dbtDtTm = value;
    }

    /**
     * Gets the value of the cdtDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCdtDtTm() {
        return cdtDtTm;
    }

    /**
     * Sets the value of the cdtDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCdtDtTm(XMLGregorianCalendar value) {
        this.cdtDtTm = value;
    }

}
