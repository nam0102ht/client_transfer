package com.ntnn.wsld;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CdtTrfTxInfSts", propOrder = {
        "instrId", "endToEndId", "txId", "clrSysRef", "success", "errorCode", "errorMessage"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditTransferTransaction30Status {
    @XmlElement(name = "InstrId")
    protected String instrId;
    @XmlElement(name = "EndToEndId", required = true)
    protected String endToEndId;
    @XmlElement(name = "TxId", required = true)
    protected String txId;
    @XmlElement(name = "ClrSysRef")
    protected String clrSysRef;
    @XmlElement(name = "Success", required = true)
    private boolean success;
    @XmlElement(name = "ErrCd")
    private String errorCode;
    @XmlElement(name = "ErrMsg")
    private String errorMessage;
}
