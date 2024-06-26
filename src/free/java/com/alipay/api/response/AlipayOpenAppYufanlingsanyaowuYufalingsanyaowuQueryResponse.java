package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.app.yufanlingsanyaowu.yufalingsanyaowu.query response.
 *
 * @author auto create
 * @since 1.0, 2017-07-25 09:12:04
 */
public class AlipayOpenAppYufanlingsanyaowuYufalingsanyaowuQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2256478742514258573L;

	/**
	 * 10
	 */
	@ApiField("userid")
	private String userid;

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return this.userid;
	}

}
