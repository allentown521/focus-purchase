package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 生活号广告位添加接口
 *
 * @author auto create
 * @since 1.0, 2018-04-09 10:45:33
 */
public class AlipayOpenPublicAdvertCreateModel extends AlipayObject {

	private static final long serialVersionUID = 1882664383944764887L;

	/**
	 * 广告位轮播内容列表，数量限制：大于1个，小于3个，广告位轮播内容顺序，根据接口传入的顺序排列
	 */
	@ApiListField("advert_items")
	@ApiField("advert_item")
	private List<AdvertItem> advertItems;

	public List<AdvertItem> getAdvertItems() {
		return this.advertItems;
	}

	public void setAdvertItems(List<AdvertItem> advertItems) {
		this.advertItems = advertItems;
	}

}
