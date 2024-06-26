package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.message.content.modify response.
 *
 * @author auto create
 * @since 1.0, 2018-02-09 16:28:22
 */
public class AlipayOpenPublicMessageContentModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 6213117837317884788L;

	/**
	 * 内容id
	 */
	@ApiField("content_id")
	private String contentId;

	/**
	 * 内容详情内链url
	 */
	@ApiField("content_url")
	private String contentUrl;

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getContentUrl() {
		return this.contentUrl;
	}

}
