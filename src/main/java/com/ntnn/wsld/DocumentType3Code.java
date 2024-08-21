
package com.ntnn.wsld;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for DocumentType3Code</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="DocumentType3Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="RADM"/>
 *     <enumeration value="RPIN"/>
 *     <enumeration value="FXDR"/>
 *     <enumeration value="DISP"/>
 *     <enumeration value="PUOR"/>
 *     <enumeration value="SCOR"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "DocumentType3Code")
@XmlEnum
public enum DocumentType3Code {

    RADM,
    RPIN,
    FXDR,
    DISP,
    PUOR,
    SCOR;

    public String value() {
        return name();
    }

    public static DocumentType3Code fromValue(String v) {
        return valueOf(v);
    }

}
