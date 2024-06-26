package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 联行信息查询接口
 *
 * @author auto create
 * @since 1.0, 2018-04-26 13:56:50
 */
public class AlipayEbppProdmodeUnionbankQueryModel extends AlipayObject {

    private static final long serialVersionUID = 5248754697588991967L;

    /**
     * 银联编号
     */
    @ApiField("bank_code")
    private String bankCode;

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

}
