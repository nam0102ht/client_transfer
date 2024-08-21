package com.ntnn.dto;

import com.prowidesoftware.swift.model.mx.dic.Contact4;
import com.prowidesoftware.swift.model.mx.dic.GroupHeader95;
import com.prowidesoftware.swift.model.mx.dic.Party38Choice;
import com.prowidesoftware.swift.model.mx.dic.PostalAddress24;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransferMoneyRequest {
    private PartyProfile partyProfile;
    private Contact4 contact;
    private Party38Choice partyChoice;
    private PostalAddress24 postalAddress;
    private GroupHeader95 groupHeader;
}
