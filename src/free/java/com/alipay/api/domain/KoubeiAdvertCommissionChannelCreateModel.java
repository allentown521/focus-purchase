package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 渠道新增接口
 *
 * @author auto create
 * @since 1.0, 2017-03-03 10:40:48
 */
public class KoubeiAdvertCommissionChannelCreateModel extends AlipayObject {

	private static final long serialVersionUID = 8625484356315335686L;

	/**
	 * 新增渠道列表
	 */
	@ApiListField("channels")
	@ApiField("kb_advert_add_channel_request")
	private List<KbAdvertAddChannelRequest> channels;

	public List<KbAdvertAddChannelRequest> getChannels() {
		return this.channels;
	}

	public void setChannels(List<KbAdvertAddChannelRequest> channels) {
		this.channels = channels;
	}

}
