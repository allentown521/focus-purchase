package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询报价详情接口
 *
 * @author auto create
 * @since 1.0, 2018-01-09 11:33:25
 */
public class AlipayInsAutoAutoinsprodQuoteQueryModel extends AlipayObject {

    private static final long serialVersionUID = 4424446311456553651L;

    /**
     * 询价ID
     */
    @ApiField("enquiry_biz_id")
    private String enquiryBizId;

    /**
     * 报价ID
     */
    @ApiField("quote_biz_id")
    private String quoteBizId;

    public String getEnquiryBizId() {
        return this.enquiryBizId;
    }

    public void setEnquiryBizId(String enquiryBizId) {
        this.enquiryBizId = enquiryBizId;
    }

    public String getQuoteBizId() {
        return this.quoteBizId;
    }

    public void setQuoteBizId(String quoteBizId) {
        this.quoteBizId = quoteBizId;
    }

}
