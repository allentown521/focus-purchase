package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CreditResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ecapiprod.credit.get response.
 *
 * @author auto create
 * @since 1.0, 2015-04-02 16:44:25
 */
public class AlipayEcapiprodCreditGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 3189213538571317338L;

	/**
	 * 授信结果
	 */
	@ApiField("credit_result")
	private CreditResult creditResult;

	/**
	 * 为了保持幂等性，返回唯一请求号
	 */
	@ApiField("request_id")
	private String requestId;

	public void setCreditResult(CreditResult creditResult) {
		this.creditResult = creditResult;
	}

	public CreditResult getCreditResult() {
		return this.creditResult;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

}
