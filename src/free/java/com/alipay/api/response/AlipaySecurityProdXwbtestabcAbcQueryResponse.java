package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.xwbtestabc.abc.query response.
 *
 * @author auto create
 * @since 1.0, 2017-11-17 11:00:06
 */
public class AlipaySecurityProdXwbtestabcAbcQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5142786876445465289L;

	/**
	 * 1
	 */
	@ApiField("xwb")
	private String xwb;

	public void setXwb(String xwb) {
		this.xwb = xwb;
	}

	public String getXwb() {
		return this.xwb;
	}

}
