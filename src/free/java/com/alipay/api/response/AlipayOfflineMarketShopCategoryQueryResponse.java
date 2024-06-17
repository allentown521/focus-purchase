package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ShopCategoryConfigInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.offline.market.shop.category.query response.
 *
 * @author auto create
 * @since 1.0, 2017-07-19 16:56:09
 */
public class AlipayOfflineMarketShopCategoryQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4453797173844251683L;

	/**
	 * 门店类目配置信息，包括能够开店的叶子节点类目信息，以及类目约束配置信息。
	 */
	@ApiListField("shop_category_config_infos")
	@ApiField("shop_category_config_info")
	private List<ShopCategoryConfigInfo> shopCategoryConfigInfos;

	public void setShopCategoryConfigInfos(List<ShopCategoryConfigInfo> shopCategoryConfigInfos) {
		this.shopCategoryConfigInfos = shopCategoryConfigInfos;
	}

	public List<ShopCategoryConfigInfo> getShopCategoryConfigInfos() {
		return this.shopCategoryConfigInfos;
	}

}
