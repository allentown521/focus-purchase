package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.life.aboard.apply response.
 *
 * @author auto create
 * @since 1.0, 2017-10-10 11:15:32
 */
public class AlipayOpenPublicLifeAboardApplyResponse extends AlipayResponse {

	private static final long serialVersionUID = 5799463944741562539L;

	/**
	 * 上架成功后返回的提示
	 */
	@ApiField("result")
	private String result;

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return this.result;
	}

}
