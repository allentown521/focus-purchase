package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

/**
 * 券账单信息
 *
 * @author auto create
 * @since 1.0, 2017-09-25 10:26:02
 */
public class VoucherBillDetail extends AlipayObject {

	private static final long serialVersionUID = 1596863841263783512L;

	/**
	 * 券核销/退款金额
	 */
	@ApiField("amount")
	private Long amount;

	/**
	 * 账单类型(V_USE:支付,V_REFUND:退款)
	 */
	@ApiField("biz_type")
	private String bizType;

	/**
	 * 交易时间
	 */
	@ApiField("gmt_create")
	private Date gmtCreate;

	/**
	 * 交易合作伙伴ID
	 */
	@ApiField("partner_id")
	private String partnerId;

	/**
	 * 商户名称
	 */
	@ApiField("partner_name")
	private String partnerName;

	/**
	 * 交易状态(I: 处理中, S: 成功)
	 */
	@ApiField("status")
	private String status;

	/**
	 * 支付宝交易号
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getBizType() {
		return this.bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

}
