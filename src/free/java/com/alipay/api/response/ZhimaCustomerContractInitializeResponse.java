package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.contract.initialize response.
 *
 * @author auto create
 * @since 1.0, 2017-12-19 13:55:57
 */
public class ZhimaCustomerContractInitializeResponse extends AlipayResponse {

	private static final long serialVersionUID = 6258422418363239361L;

	/**
	 * 电子合约号，后续的电子签名流程需要用到
	 */
	@ApiField("contract_no")
	private String contractNo;

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractNo() {
		return this.contractNo;
	}

}
