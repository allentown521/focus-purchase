package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.data.upload.initialize response.
 *
 * @author auto create
 * @since 1.0, 2018-04-08 13:55:00
 */
public class ZhimaMerchantDataUploadInitializeResponse extends AlipayResponse {

	private static final long serialVersionUID = 3597113512115783785L;

	/**
	 * 行业模板
	 */
	@ApiField("template_url")
	private String templateUrl;

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public String getTemplateUrl() {
		return this.templateUrl;
	}

}
