package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.data.enterprise.staffinfo.upload response.
 *
 * @author auto create
 * @since 1.0, 2017-07-25 15:32:34
 */
public class KoubeiMarketingDataEnterpriseStaffinfoUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 8112439723626658135L;

	/**
	 * 人群ID
	 */
	@ApiField("crowd_id")
	private String crowdId;

	public void setCrowdId(String crowdId) {
		this.crowdId = crowdId;
	}

	public String getCrowdId() {
		return this.crowdId;
	}

}
