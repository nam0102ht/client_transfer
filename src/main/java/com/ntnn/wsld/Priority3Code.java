
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for Priority3Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="Priority3Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="URGT"/>
 *     <enumeration value="HIGH"/>
 *     <enumeration value="NORM"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "Priority3Code")
@XmlEnum
public enum Priority3Code {

    URGT,
    HIGH,
    NORM;

    public String value() {
        return name();
    }

    public static Priority3Code fromValue(String v) {
        return valueOf(v);
    }

}
