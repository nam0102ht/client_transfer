
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for Instruction3Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="Instruction3Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CHQB"/>
 *     <enumeration value="HOLD"/>
 *     <enumeration value="PHOB"/>
 *     <enumeration value="TELB"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "Instruction3Code")
@XmlEnum
public enum Instruction3Code {

    CHQB,
    HOLD,
    PHOB,
    TELB;

    public String value() {
        return name();
    }

    public static Instruction3Code fromValue(String v) {
        return valueOf(v);
    }

}
