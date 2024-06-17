package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 商户信息列表
 *
 * @author auto create
 * @since 1.0, 2017-08-04 15:15:46
 */
public class IsvMerchantInfo extends AlipayObject {

	private static final long serialVersionUID = 8262935959659472136L;

	/**
	 * 商户pid
	 */
	@ApiField("partner_id")
	private String partnerId;

	/**
	 * 门店ID列表
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	public String getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}

	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

}
