
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for StructuredRemittanceInformation15 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="StructuredRemittanceInformation15">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RfrdDocInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}ReferredDocumentInformation7" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="RfrdDocAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}RemittanceAmount2" minOccurs="0"/>
 *         <element name="CdtrRefInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}CreditorReferenceInformation2" minOccurs="0"/>
 *         <element name="Invcr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}PartyIdentification125" minOccurs="0"/>
 *         <element name="Invcee" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}PartyIdentification125" minOccurs="0"/>
 *         <element name="TaxRmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}TaxInformation7" minOccurs="0"/>
 *         <element name="GrnshmtRmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Garnishment2" minOccurs="0"/>
 *         <element name="AddtlRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}Max140Text" maxOccurs="3" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRemittanceInformation15", propOrder = {
    "rfrdDocInf",
    "rfrdDocAmt",
    "cdtrRefInf",
    "invcr",
    "invcee",
    "taxRmt",
    "grnshmtRmt",
    "addtlRmtInf"
})
public class StructuredRemittanceInformation15 {

    @XmlElement(name = "RfrdDocInf")
    protected List<ReferredDocumentInformation7> rfrdDocInf;
    @XmlElement(name = "RfrdDocAmt")
    protected RemittanceAmount2 rfrdDocAmt;
    @XmlElement(name = "CdtrRefInf")
    protected CreditorReferenceInformation2 cdtrRefInf;
    @XmlElement(name = "Invcr")
    protected PartyIdentification125 invcr;
    @XmlElement(name = "Invcee")
    protected PartyIdentification125 invcee;
    @XmlElement(name = "TaxRmt")
    protected TaxInformation7 taxRmt;
    @XmlElement(name = "GrnshmtRmt")
    protected Garnishment2 grnshmtRmt;
    @XmlElement(name = "AddtlRmtInf")
    protected List<String> addtlRmtInf;

    /**
     * Gets the value of the rfrdDocInf property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rfrdDocInf property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getRfrdDocInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferredDocumentInformation7 }
     * </p>
     * 
     * 
     * @return
     *     The value of the rfrdDocInf property.
     */
    public List<ReferredDocumentInformation7> getRfrdDocInf() {
        if (rfrdDocInf == null) {
            rfrdDocInf = new ArrayList<>();
        }
        return this.rfrdDocInf;
    }

    /**
     * Gets the value of the rfrdDocAmt property.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceAmount2 }
     *     
     */
    public RemittanceAmount2 getRfrdDocAmt() {
        return rfrdDocAmt;
    }

    /**
     * Sets the value of the rfrdDocAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceAmount2 }
     *     
     */
    public void setRfrdDocAmt(RemittanceAmount2 value) {
        this.rfrdDocAmt = value;
    }

    /**
     * Gets the value of the cdtrRefInf property.
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceInformation2 }
     *     
     */
    public CreditorReferenceInformation2 getCdtrRefInf() {
        return cdtrRefInf;
    }

    /**
     * Sets the value of the cdtrRefInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceInformation2 }
     *     
     */
    public void setCdtrRefInf(CreditorReferenceInformation2 value) {
        this.cdtrRefInf = value;
    }

    /**
     * Gets the value of the invcr property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification125 }
     *     
     */
    public PartyIdentification125 getInvcr() {
        return invcr;
    }

    /**
     * Sets the value of the invcr property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification125 }
     *     
     */
    public void setInvcr(PartyIdentification125 value) {
        this.invcr = value;
    }

    /**
     * Gets the value of the invcee property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification125 }
     *     
     */
    public PartyIdentification125 getInvcee() {
        return invcee;
    }

    /**
     * Sets the value of the invcee property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification125 }
     *     
     */
    public void setInvcee(PartyIdentification125 value) {
        this.invcee = value;
    }

    /**
     * Gets the value of the taxRmt property.
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation7 }
     *     
     */
    public TaxInformation7 getTaxRmt() {
        return taxRmt;
    }

    /**
     * Sets the value of the taxRmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation7 }
     *     
     */
    public void setTaxRmt(TaxInformation7 value) {
        this.taxRmt = value;
    }

    /**
     * Gets the value of the grnshmtRmt property.
     * 
     * @return
     *     possible object is
     *     {@link Garnishment2 }
     *     
     */
    public Garnishment2 getGrnshmtRmt() {
        return grnshmtRmt;
    }

    /**
     * Sets the value of the grnshmtRmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Garnishment2 }
     *     
     */
    public void setGrnshmtRmt(Garnishment2 value) {
        this.grnshmtRmt = value;
    }

    /**
     * Gets the value of the addtlRmtInf property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addtlRmtInf property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAddtlRmtInf().add(newItem);
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
     *     The value of the addtlRmtInf property.
     */
    public List<String> getAddtlRmtInf() {
        if (addtlRmtInf == null) {
            addtlRmtInf = new ArrayList<>();
        }
        return this.addtlRmtInf;
    }

}
