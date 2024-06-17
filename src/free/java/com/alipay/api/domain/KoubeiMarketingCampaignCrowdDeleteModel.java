package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑商户人群组删除接口
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:17:50
 */
public class KoubeiMarketingCampaignCrowdDeleteModel extends AlipayObject {

    private static final long serialVersionUID = 4137792368248799542L;

    /**
     * 人群组的唯一标识ID
     */
    @ApiField("crowd_group_id")
    private String crowdGroupId;

    public String getCrowdGroupId() {
        return this.crowdGroupId;
    }

    public void setCrowdGroupId(String crowdGroupId) {
        this.crowdGroupId = crowdGroupId;
    }

}
