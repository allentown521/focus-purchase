package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zdatafront.datatransfered.send response.
 *
 * @author auto create
 * @since 1.0, 2017-05-18 11:27:33
 */
public class AlipayZdatafrontDatatransferedSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 1794752131938289881L;

	/**
	 * 表示数据传输是否成功
	 */
	@ApiField("success")
	private String success;

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getSuccess() {
		return this.success;
	}

}
