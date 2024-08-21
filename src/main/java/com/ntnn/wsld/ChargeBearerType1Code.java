
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for ChargeBearerType1Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="ChargeBearerType1Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="DEBT"/>
 *     <enumeration value="CRED"/>
 *     <enumeration value="SHAR"/>
 *     <enumeration value="SLEV"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "ChargeBearerType1Code")
@XmlEnum
public enum ChargeBearerType1Code {

    DEBT,
    CRED,
    SHAR,
    SLEV;

    public String value() {
        return name();
    }

    public static ChargeBearerType1Code fromValue(String v) {
        return valueOf(v);
    }

}
