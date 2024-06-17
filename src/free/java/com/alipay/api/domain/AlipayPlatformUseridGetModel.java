package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 根据OpenId获取UserId
 *
 * @author auto create
 * @since 1.0, 2016-02-19 20:04:41
 */
public class AlipayPlatformUseridGetModel extends AlipayObject {

	private static final long serialVersionUID = 6425889459247127565L;

	/**
	 * openId的列表
	 */
	@ApiListField("open_ids")
	@ApiField("string")
	private List<String> openIds;

	public List<String> getOpenIds() {
		return this.openIds;
	}

	public void setOpenIds(List<String> openIds) {
		this.openIds = openIds;
	}

}
