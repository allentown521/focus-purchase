package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.DiscountDetail;
import com.alipay.api.domain.MCardDetail;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.trade.order.consult response.
 *
 * @author auto create
 * @since 1.0, 2018-03-02 10:51:08
 */
public class KoubeiTradeOrderConsultResponse extends AlipayResponse {

	private static final long serialVersionUID = 4168528588135479776L;

	/**
	 * 用户实付金额
	 */
	@ApiField("buyer_pay_amount")
	private String buyerPayAmount;

	/**
	 * 优惠信息
	 */
	@ApiListField("discount_detail")
	@ApiField("discount_detail")
	private List<DiscountDetail> discountDetail;

	/**
	 * 储值卡信息
	 */
	@ApiField("m_card_detail")
	private MCardDetail mCardDetail;

	/**
	 * 请求中的request_id
	 */
	@ApiField("request_id")
	private String requestId;

	public void setBuyerPayAmount(String buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public String getBuyerPayAmount() {
		return this.buyerPayAmount;
	}

	public void setDiscountDetail(List<DiscountDetail> discountDetail) {
		this.discountDetail = discountDetail;
	}

	public List<DiscountDetail> getDiscountDetail() {
		return this.discountDetail;
	}

	public void setmCardDetail(MCardDetail mCardDetail) {
		this.mCardDetail = mCardDetail;
	}

	public MCardDetail getmCardDetail() {
		return this.mCardDetail;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

}
