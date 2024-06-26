package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.alipay.security.prod.test response.
 *
 * @author auto create
 * @since 1.0, 2016-03-03 17:43:31
 */
public class AlipaySecurityProdAlipaySecurityProdTestResponse extends AlipayResponse {

	private static final long serialVersionUID = 2738921719623255487L;

	/**
	 * ddd
	 */
	@ApiField("admin")
	private String admin;

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin() {
		return this.admin;
	}

}
