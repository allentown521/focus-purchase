package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.DiscountInfo;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.advert.delivery.discount.get response.
 *
 * @author auto create
 * @since 1.0, 2018-03-01 15:55:54
 */
public class KoubeiAdvertDeliveryDiscountGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 5116888336732583198L;

	/**
	 * 广告推荐的商品信息列表，个数小于等于请求中参数“size”个数
	 */
	@ApiField("discounts")
	private DiscountInfo discounts;

	/**
	 * 本次推荐的唯一标识， 此字段需回传
	 */
	@ApiField("recommend_id")
	private String recommendId;

	public void setDiscounts(DiscountInfo discounts) {
		this.discounts = discounts;
	}

	public DiscountInfo getDiscounts() {
		return this.discounts;
	}

	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}

	public String getRecommendId() {
		return this.recommendId;
	}

}
