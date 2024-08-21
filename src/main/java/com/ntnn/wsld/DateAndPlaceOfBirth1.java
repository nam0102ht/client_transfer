
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DateAndPlaceOfBirth1 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="DateAndPlaceOfBirth1">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="BirthDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}ISODate"/>
 *         <element name="PrvcOfBirth" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Max35Text" minOccurs="0"/>
 *         <element name="CityOfBirth" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Max35Text"/>
 *         <element name="CtryOfBirth" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}CountryCode"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateAndPlaceOfBirth1", propOrder = {
    "birthDt",
    "prvcOfBirth",
    "cityOfBirth",
    "ctryOfBirth"
})
public class DateAndPlaceOfBirth1 {

    @XmlElement(name = "BirthDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDt;
    @XmlElement(name = "PrvcOfBirth")
    protected String prvcOfBirth;
    @XmlElement(name = "CityOfBirth", required = true)
    protected String cityOfBirth;
    @XmlElement(name = "CtryOfBirth", required = true)
    protected String ctryOfBirth;

    /**
     * Gets the value of the birthDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDt() {
        return birthDt;
    }

    /**
     * Sets the value of the birthDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDt(XMLGregorianCalendar value) {
        this.birthDt = value;
    }

    /**
     * Gets the value of the prvcOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrvcOfBirth() {
        return prvcOfBirth;
    }

    /**
     * Sets the value of the prvcOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrvcOfBirth(String value) {
        this.prvcOfBirth = value;
    }

    /**
     * Gets the value of the cityOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityOfBirth() {
        return cityOfBirth;
    }

    /**
     * Sets the value of the cityOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityOfBirth(String value) {
        this.cityOfBirth = value;
    }

    /**
     * Gets the value of the ctryOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtryOfBirth() {
        return ctryOfBirth;
    }

    /**
     * Sets the value of the ctryOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtryOfBirth(String value) {
        this.ctryOfBirth = value;
    }

}
