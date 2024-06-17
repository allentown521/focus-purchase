package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.app.xwbtestabc.query response.
 *
 * @author auto create
 * @since 1.0, 2017-12-04 17:55:09
 */
public class AlipayOpenAppXwbtestabcQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4837789968267448714L;

	/**
	 * 1
	 */
	@ApiField("xw")
	private String xw;

	public void setXw(String xw) {
		this.xw = xw;
	}

	public String getXw() {
		return this.xw;
	}

}
