
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for RemittanceLocationMethod2Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="RemittanceLocationMethod2Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="FAXI"/>
 *     <enumeration value="EDIC"/>
 *     <enumeration value="URID"/>
 *     <enumeration value="EMAL"/>
 *     <enumeration value="POST"/>
 *     <enumeration value="SMSM"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "RemittanceLocationMethod2Code")
@XmlEnum
public enum RemittanceLocationMethod2Code {

    FAXI,
    EDIC,
    URID,
    EMAL,
    POST,
    SMSM;

    public String value() {
        return name();
    }

    public static RemittanceLocationMethod2Code fromValue(String v) {
        return valueOf(v);
    }

}
