package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.quality.test.cloudacpt.checkresult.submit response.
 *
 * @author auto create
 * @since 1.0, 2016-06-15 15:06:55
 */
public class KoubeiQualityTestCloudacptCheckresultSubmitResponse extends AlipayResponse {

	private static final long serialVersionUID = 1442574126688233825L;

	/**
	 * 活动id
	 */
	@ApiField("activity_id")
	private String activityId;

	/**
	 * 批次
	 */
	@ApiField("batch_id")
	private String batchId;

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityId() {
		return this.activityId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchId() {
		return this.batchId;
	}

}
