package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zdataassets.easyservice response.
 *
 * @author auto create
 * @since 1.0, 2017-04-26 15:11:21
 */
public class AlipayZdataassetsEasyserviceResponse extends AlipayResponse {

	private static final long serialVersionUID = 4218493874146673395L;

	/**
	 * 返回结果
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
