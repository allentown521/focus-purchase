package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.signature.task.cancel response.
 *
 * @author auto create
 * @since 1.0, 2017-12-20 15:25:04
 */
public class AlipaySecurityProdSignatureTaskCancelResponse extends AlipayResponse {

	private static final long serialVersionUID = 3119862634466139874L;

	/**
	 * 是否更新成功
	 */
	@ApiField("success")
	private Boolean success;

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess() {
		return this.success;
	}

}
