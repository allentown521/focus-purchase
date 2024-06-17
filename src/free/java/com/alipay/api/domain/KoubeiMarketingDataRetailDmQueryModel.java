package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 快消店铺DM浏览数据查询接口
 *
 * @author auto create
 * @since 1.0, 2017-05-16 17:02:42
 */
public class KoubeiMarketingDataRetailDmQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8324215762712943552L;

	/**
	 * 内容ID，调用koubei.marketing.campaign.retail.dm.create创建内容时返回的内容ID
	 */
	@ApiField("content_id")
	private String contentId;

	/**
	 * 门店ID
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}

	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

}
