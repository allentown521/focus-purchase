package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.commerce.cityfacilitator.voucher.generate response.
 *
 * @author auto create
 * @since 1.0, 2016-08-03 16:10:34
 */
public class AlipayCommerceCityfacilitatorVoucherGenerateResponse extends AlipayResponse {

	private static final long serialVersionUID = 8571792628595844616L;

	/**
	 * 核销码过期时间
	 */
	@ApiField("expired_date")
	private String expiredDate;

	/**
	 * 地铁购票二维码编码，可自定义
	 */
	@ApiField("qr_code_no")
	private String qrCodeNo;

	/**
	 * 地铁购票的核销码
	 */
	@ApiField("ticket_no")
	private String ticketNo;

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getExpiredDate() {
		return this.expiredDate;
	}

	public void setQrCodeNo(String qrCodeNo) {
		this.qrCodeNo = qrCodeNo;
	}

	public String getQrCodeNo() {
		return this.qrCodeNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketNo() {
		return this.ticketNo;
	}

}
