
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for Instruction4Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="Instruction4Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="PHOA"/>
 *     <enumeration value="TELA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "Instruction4Code")
@XmlEnum
public enum Instruction4Code {

    PHOA,
    TELA;

    public String value() {
        return name();
    }

    public static Instruction4Code fromValue(String v) {
        return valueOf(v);
    }

}
