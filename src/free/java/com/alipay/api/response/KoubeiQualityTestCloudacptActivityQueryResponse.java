package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.OpenActivity;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.quality.test.cloudacpt.activity.query response.
 *
 * @author auto create
 * @since 1.0, 2016-06-15 15:07:41
 */
public class KoubeiQualityTestCloudacptActivityQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4758231686436915696L;

	/**
	 * 活动列表
	 */
	@ApiListField("activity_list")
	@ApiField("open_activity")
	private List<OpenActivity> activityList;

	public void setActivityList(List<OpenActivity> activityList) {
		this.activityList = activityList;
	}

	public List<OpenActivity> getActivityList() {
		return this.activityList;
	}

}
