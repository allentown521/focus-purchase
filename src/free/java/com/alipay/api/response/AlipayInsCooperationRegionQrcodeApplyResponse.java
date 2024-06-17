package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.cooperation.region.qrcode.apply response.
 *
 * @author auto create
 * @since 1.0, 2017-10-24 10:29:59
 */
public class AlipayInsCooperationRegionQrcodeApplyResponse extends AlipayResponse {

	private static final long serialVersionUID = 7181926442617212732L;

	/**
	 * 快捷投保产品二维码图片链接URL
	 */
	@ApiField("code_url")
	private String codeUrl;

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getCodeUrl() {
		return this.codeUrl;
	}

}
