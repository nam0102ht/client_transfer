
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for RemittanceInformation15 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="RemittanceInformation15">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Ustrd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Max140Text" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="Strd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}StructuredRemittanceInformation15" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemittanceInformation15", propOrder = {
    "ustrd",
    "strd"
})
public class RemittanceInformation15 {

    @XmlElement(name = "Ustrd")
    protected List<String> ustrd;
    @XmlElement(name = "Strd")
    protected List<StructuredRemittanceInformation15> strd;

    /**
     * Gets the value of the ustrd property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ustrd property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getUstrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * </p>
     * 
     * 
     * @return
     *     The value of the ustrd property.
     */
    public List<String> getUstrd() {
        if (ustrd == null) {
            ustrd = new ArrayList<>();
        }
        return this.ustrd;
    }

    /**
     * Gets the value of the strd property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the strd property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getStrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructuredRemittanceInformation15 }
     * </p>
     * 
     * 
     * @return
     *     The value of the strd property.
     */
    public List<StructuredRemittanceInformation15> getStrd() {
        if (strd == null) {
            strd = new ArrayList<>();
        }
        return this.strd;
    }

}
