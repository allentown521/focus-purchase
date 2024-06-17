package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 创建广告推广内容
 *
 * @author auto create
 * @since 1.0, 2017-01-17 10:33:35
 */
public class KoubeiAdvertCommissionAdvchannelUnbindModel extends AlipayObject {

	private static final long serialVersionUID = 6585925639614137414L;

	/**
	 * 广告ID
	 */
	@ApiField("adv_id")
	private String advId;

	/**
	 * 渠道ID列表
	 */
	@ApiListField("channel_id_list")
	@ApiField("string")
	private List<String> channelIdList;

	public String getAdvId() {
		return this.advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public List<String> getChannelIdList() {
		return this.channelIdList;
	}

	public void setChannelIdList(List<String> channelIdList) {
		this.channelIdList = channelIdList;
	}

}
