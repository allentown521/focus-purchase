package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSpaceMemberCreateModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.member.create response.
 *
 * @author auto create
 * @since 1.0, 2018-05-17 14:50:00
 */
public class AlipayMarketingToolFengdieMemberCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 7631181333264966738L;

	/**
	 * 凤蝶业务空间创建成功后，返回该成员的基本信息
	 */
	@ApiField("data")
	private FengdieSpaceMemberCreateModel data;

	public void setData(FengdieSpaceMemberCreateModel data) {
		this.data = data;
	}

	public FengdieSpaceMemberCreateModel getData() {
		return this.data;
	}

}
