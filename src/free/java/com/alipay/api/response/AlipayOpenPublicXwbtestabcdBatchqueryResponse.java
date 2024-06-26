package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.xwbtestabcd.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2017-12-21 18:51:53
 */
public class AlipayOpenPublicXwbtestabcdBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6648334382674799369L;

	/**
	 * 1111
	 */
	@ApiField("b")
	private String b;

	public void setB(String b) {
		this.b = b;
	}

	public String getB() {
		return this.b;
	}

}
