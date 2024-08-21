
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for NamePrefix1Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="NamePrefix1Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="DOCT"/>
 *     <enumeration value="MIST"/>
 *     <enumeration value="MISS"/>
 *     <enumeration value="MADM"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "NamePrefix1Code")
@XmlEnum
public enum NamePrefix1Code {

    DOCT,
    MIST,
    MISS,
    MADM;

    public String value() {
        return name();
    }

    public static NamePrefix1Code fromValue(String v) {
        return valueOf(v);
    }

}
