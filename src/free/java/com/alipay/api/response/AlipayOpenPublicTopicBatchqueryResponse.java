package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Topic;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.topic.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 15:06:33
 */
public class AlipayOpenPublicTopicBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6244723475677967449L;

	/**
	 * 营销位列表
	 */
	@ApiListField("topic_list")
	@ApiField("topic")
	private List<Topic> topicList;

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Topic> getTopicList() {
		return this.topicList;
	}

}
