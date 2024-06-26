package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayContract;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.user.contract.get response.
 *
 * @author auto create
 * @since 1.0, 2016-06-06 20:23:18
 */
public class AlipayUserContractGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 6274834128847379258L;

	/**
	 * 支付宝用户订购信息
	 */
	@ApiField("alipay_contract")
	private AlipayContract alipayContract;

	public void setAlipayContract(AlipayContract alipayContract) {
		this.alipayContract = alipayContract;
	}

	public AlipayContract getAlipayContract() {
		return this.alipayContract;
	}

}
