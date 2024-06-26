package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.trade.ticket.ticketcode.send response.
 *
 * @author auto create
 * @since 1.0, 2018-05-02 14:41:39
 */
public class KoubeiTradeTicketTicketcodeSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 6266823228821222886L;

	/**
	 * 该字段用于描述本次返回中的业务属性，现有：BIZ_ALREADY_SUCCESS（幂等业务码）。
	 */
	@ApiField("biz_code")
	private String bizCode;

	/**
	 * 请求id
	 */
	@ApiField("request_id")
	private String requestId;

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getBizCode() {
		return this.bizCode;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

}
