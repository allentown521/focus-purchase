package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 会员卡模板外部权益查询
 *
 * @author auto create
 * @since 1.0, 2018-01-10 18:26:27
 */
public class AlipayMarketingCardBenefitQueryModel extends AlipayObject {

    private static final long serialVersionUID = 7347463983296637818L;

    /**
     * 权益ID
     */
    @ApiField("benefit_id")
    private String benefitId;

    /**
     * 会员卡模板ID
     */
    @ApiField("template_id")
    private String templateId;

    public String getBenefitId() {
        return this.benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

}
