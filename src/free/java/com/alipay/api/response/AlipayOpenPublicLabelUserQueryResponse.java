package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.label.user.query response.
 *
 * @author auto create
 * @since 1.0, 2016-12-08 11:53:10
 */
public class AlipayOpenPublicLabelUserQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1675968163576565771L;

	/**
	 * 用户标签id列表，以英文逗号分隔
	 */
	@ApiField("label_ids")
	private String labelIds;

	public void setLabelIds(String labelIds) {
		this.labelIds = labelIds;
	}

	public String getLabelIds() {
		return this.labelIds;
	}

}
