package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayUserDetail;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.user.get response.
 *
 * @author auto create
 * @since 1.0, 2018-02-28 16:34:11
 */
public class AlipayUserGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 1111424812553325461L;

	/**
	 * 支付宝用户信息
	 */
	@ApiField("alipay_user_detail")
	private AlipayUserDetail alipayUserDetail;

	public void setAlipayUserDetail(AlipayUserDetail alipayUserDetail) {
		this.alipayUserDetail = alipayUserDetail;
	}

	public AlipayUserDetail getAlipayUserDetail() {
		return this.alipayUserDetail;
	}

}
