package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.topic.create response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 17:38:29
 */
public class AlipayOpenPublicTopicCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 6352216139279786536L;

	/**
	 * 营销位id
	 */
	@ApiField("topic_id")
	private String topicId;

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicId() {
		return this.topicId;
	}

}
