package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.pcredit.huabei.promo.query response.
 *
 * @author auto create
 * @since 1.0, 2016-03-03 17:48:05
 */
public class AlipayPcreditHuabeiPromoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6821791711758462672L;

	/**
	 * 花呗颜值分
	 */
	@ApiField("facescore")
	private String facescore;

	public void setFacescore(String facescore) {
		this.facescore = facescore;
	}

	public String getFacescore() {
		return this.facescore;
	}

}
