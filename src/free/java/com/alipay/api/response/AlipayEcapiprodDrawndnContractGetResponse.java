package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ecapiprod.drawndn.contract.get response.
 *
 * @author auto create
 * @since 1.0, 2016-03-29 11:34:32
 */
public class AlipayEcapiprodDrawndnContractGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 1691271459214438764L;

	/**
	 * 合同的内容文本	String	合同的内容文本，为HTML格式
	 */
	@ApiField("contract_content")
	private String contractContent;

	/**
	 * 合同编号
	 */
	@ApiField("contract_no")
	private String contractNo;

	/**
	 * 唯一标识这次请求
	 */
	@ApiField("request_id")
	private String requestId;

	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}

	public String getContractContent() {
		return this.contractContent;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractNo() {
		return this.contractNo;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

}
