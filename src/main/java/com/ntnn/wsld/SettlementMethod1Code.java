
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for SettlementMethod1Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="SettlementMethod1Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="INDA"/>
 *     <enumeration value="INGA"/>
 *     <enumeration value="COVE"/>
 *     <enumeration value="CLRG"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "SettlementMethod1Code")
@XmlEnum
public enum SettlementMethod1Code {

    INDA,
    INGA,
    COVE,
    CLRG;

    public String value() {
        return name();
    }

    public static SettlementMethod1Code fromValue(String v) {
        return valueOf(v);
    }

}
