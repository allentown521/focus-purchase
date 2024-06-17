package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 商圈店铺活动信息
 *
 * @author auto create
 * @since 1.0, 2017-06-20 15:01:09
 */
public class KoubeiMarketingMallShoppromoinfoQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7582526894477748626L;

	/**
	 * 商圈id
	 */
	@ApiField("mall_id")
	private String mallId;

	/**
	 * 商圈下店铺id列表
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	public String getMallId() {
		return this.mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}

	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

}
