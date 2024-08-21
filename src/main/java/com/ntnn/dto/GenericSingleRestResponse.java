package com.ntnn.dto;

import com.ntnn.wsld.CreditTransferTransaction30Status;
import com.ntnn.wsld.GroupHeader70;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseDocument", propOrder = {
        "grpHdr", "cdtTrfTxInfSts"
})
@XmlRootElement()
public class GenericSingleRestResponse {

    @Getter
    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader70 grpHdr;

    @XmlElement(name = "CdtTrfTxInfSts", required = true)
    protected List<CreditTransferTransaction30Status> cdtTrfTxInfSts;

    public void setGrpHdr(GroupHeader70 grpHdr) {
        this.grpHdr = grpHdr;
    }

    public List<CreditTransferTransaction30Status> getCdtTrfTxInfSts() {
        if (cdtTrfTxInfSts == null) {
            cdtTrfTxInfSts = new ArrayList<>();
        }
        return cdtTrfTxInfSts;
    }
}
