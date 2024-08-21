package com.ntnn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransferMoneyResponse {
    private String rspCode;
    private String rsnCode;
    private String rsnDesc;
}
