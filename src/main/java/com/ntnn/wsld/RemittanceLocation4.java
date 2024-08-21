
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for RemittanceLocation4 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="RemittanceLocation4">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RmtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Max35Text" minOccurs="0"/>
 *         <element name="RmtLctnDtls" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}RemittanceLocationDetails1" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemittanceLocation4", propOrder = {
    "rmtId",
    "rmtLctnDtls"
})
public class RemittanceLocation4 {

    @XmlElement(name = "RmtId")
    protected String rmtId;
    @XmlElement(name = "RmtLctnDtls")
    protected List<RemittanceLocationDetails1> rmtLctnDtls;

    /**
     * Gets the value of the rmtId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmtId() {
        return rmtId;
    }

    /**
     * Sets the value of the rmtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmtId(String value) {
        this.rmtId = value;
    }

    /**
     * Gets the value of the rmtLctnDtls property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmtLctnDtls property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getRmtLctnDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemittanceLocationDetails1 }
     * </p>
     * 
     * 
     * @return
     *     The value of the rmtLctnDtls property.
     */
    public List<RemittanceLocationDetails1> getRmtLctnDtls() {
        if (rmtLctnDtls == null) {
            rmtLctnDtls = new ArrayList<>();
        }
        return this.rmtLctnDtls;
    }

}
