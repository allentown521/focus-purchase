package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 押品信息查询
 *
 * @author auto create
 * @since 1.0, 2018-05-03 21:03:15
 */
public class AlipayPcreditLoanCollateralCarQueryModel extends AlipayObject {

    private static final long serialVersionUID = 1169319341238535953L;

    /**
     * 业务流水号，即用户授信申请的单号，每次授信申请由借呗平台生成的唯一编号，通知估值时给到机构
     */
    @ApiField("apply_no")
    private String applyNo;

    public String getApplyNo() {
        return this.applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

}
