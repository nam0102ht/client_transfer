
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for PersonIdentification13 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="PersonIdentification13">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="DtAndPlcOfBirth" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}DateAndPlaceOfBirth1" minOccurs="0"/>
 *         <element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}GenericPersonIdentification1" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonIdentification13", propOrder = {
    "dtAndPlcOfBirth",
    "othr"
})
public class PersonIdentification13 {

    @XmlElement(name = "DtAndPlcOfBirth")
    protected DateAndPlaceOfBirth1 dtAndPlcOfBirth;
    @XmlElement(name = "Othr")
    protected List<GenericPersonIdentification1> othr;

    /**
     * Gets the value of the dtAndPlcOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link DateAndPlaceOfBirth1 }
     *     
     */
    public DateAndPlaceOfBirth1 getDtAndPlcOfBirth() {
        return dtAndPlcOfBirth;
    }

    /**
     * Sets the value of the dtAndPlcOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndPlaceOfBirth1 }
     *     
     */
    public void setDtAndPlcOfBirth(DateAndPlaceOfBirth1 value) {
        this.dtAndPlcOfBirth = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getOthr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPersonIdentification1 }
     * </p>
     * 
     * 
     * @return
     *     The value of the othr property.
     */
    public List<GenericPersonIdentification1> getOthr() {
        if (othr == null) {
            othr = new ArrayList<>();
        }
        return this.othr;
    }

}
