package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zoloz.identification.user.web.query response.
 *
 * @author auto create
 * @since 1.0, 2018-03-05 11:34:47
 */
public class ZolozIdentificationUserWebQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7361185285955665314L;

	/**
	 * 扩展结果
	 */
	@ApiField("extern_info")
	private String externInfo;

	public void setExternInfo(String externInfo) {
		this.externInfo = externInfo;
	}

	public String getExternInfo() {
		return this.externInfo;
	}

}
