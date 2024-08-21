
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for AddressType2Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="AddressType2Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ADDR"/>
 *     <enumeration value="PBOX"/>
 *     <enumeration value="HOME"/>
 *     <enumeration value="BIZZ"/>
 *     <enumeration value="MLTO"/>
 *     <enumeration value="DLVY"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "AddressType2Code")
@XmlEnum
public enum AddressType2Code {

    ADDR,
    PBOX,
    HOME,
    BIZZ,
    MLTO,
    DLVY;

    public String value() {
        return name();
    }

    public static AddressType2Code fromValue(String v) {
        return valueOf(v);
    }

}
