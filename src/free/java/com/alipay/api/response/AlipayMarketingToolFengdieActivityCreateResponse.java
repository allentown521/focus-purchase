package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.activity.create response.
 *
 * @author auto create
 * @since 1.0, 2018-07-02 10:31:23
 */
public class AlipayMarketingToolFengdieActivityCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 4755639143641417314L;

	/**
	 * H5应用的唯一id
	 */
	@ApiField("activity_id")
	private Long activityId;

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

}
