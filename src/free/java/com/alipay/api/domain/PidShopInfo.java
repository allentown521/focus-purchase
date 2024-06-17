package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 招商pid和pid对应的门第列表
 *
 * @author auto create
 * @since 1.0, 2017-06-05 11:25:25
 */
public class PidShopInfo extends AlipayObject {

	private static final long serialVersionUID = 8312127257364563775L;

	/**
	 * 商户pid
	 */
	@ApiField("pid")
	private String pid;

	/**
	 * pid下的门店列表
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}

	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

}
