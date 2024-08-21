
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for RegulatoryReportingType1Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="RegulatoryReportingType1Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CRED"/>
 *     <enumeration value="DEBT"/>
 *     <enumeration value="BOTH"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "RegulatoryReportingType1Code")
@XmlEnum
public enum RegulatoryReportingType1Code {

    CRED,
    DEBT,
    BOTH;

    public String value() {
        return name();
    }

    public static RegulatoryReportingType1Code fromValue(String v) {
        return valueOf(v);
    }

}
