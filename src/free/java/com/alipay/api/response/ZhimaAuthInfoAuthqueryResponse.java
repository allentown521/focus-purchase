package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.info.authquery response.
 *
 * @author auto create
 * @since 1.0, 2017-10-19 18:38:54
 */
public class ZhimaAuthInfoAuthqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5494957711199242174L;

	/**
	 * 是否已经授权,已授权:true,未授权:false
	 */
	@ApiField("authorized")
	private Boolean authorized;

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}

	public Boolean getAuthorized() {
		return this.authorized;
	}

}
