package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 解锁操作员接口
 *
 * @author auto create
 * @since 1.0, 2018-03-23 14:23:47
 */
public class KoubeiMerchantOperatorUnfreezeModel extends AlipayObject {

    private static final long serialVersionUID = 6258586768283211895L;

    /**
     * 授权码
     */
    @ApiField("auth_code")
    private String authCode;

    /**
     * 操作员ID
     */
    @ApiField("operator_id")
    private String operatorId;

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

}
