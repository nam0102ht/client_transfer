
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for FIToFICustomerCreditTransferV07 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="FIToFICustomerCreditTransferV07">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}GroupHeader70"/>
 *         <element name="CdtTrfTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}CreditTransferTransaction30" maxOccurs="unbounded"/>
 *         <element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIToFICustomerCreditTransferV07", propOrder = {
    "grpHdr",
    "cdtTrfTxInf",
    "splmtryData"
})
public class FIToFICustomerCreditTransferV07 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader70 grpHdr;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected List<CreditTransferTransaction30> cdtTrfTxInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader70 }
     *     
     */
    public GroupHeader70 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader70 }
     *     
     */
    public void setGrpHdr(GroupHeader70 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the cdtTrfTxInf property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdtTrfTxInf property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCdtTrfTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditTransferTransaction30 }
     * </p>
     * 
     * 
     * @return
     *     The value of the cdtTrfTxInf property.
     */
    public List<CreditTransferTransaction30> getCdtTrfTxInf() {
        if (cdtTrfTxInf == null) {
            cdtTrfTxInf = new ArrayList<>();
        }
        return this.cdtTrfTxInf;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * </p>
     * 
     * 
     * @return
     *     The value of the splmtryData property.
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<>();
        }
        return this.splmtryData;
    }

}
