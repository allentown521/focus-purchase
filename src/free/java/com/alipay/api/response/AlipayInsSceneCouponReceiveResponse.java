package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.InsProduct;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.scene.coupon.receive response.
 *
 * @author auto create
 * @since 1.0, 2017-02-23 21:17:48
 */
public class AlipayInsSceneCouponReceiveResponse extends AlipayResponse {

	private static final long serialVersionUID = 3613924947697545518L;

	/**
	 * 保单凭证号;商户生成的外部投保业务号不传时则必传
	 */
	@ApiField("policy_no")
	private String policyNo;

	/**
	 * 保险产品
	 */
	@ApiField("product")
	private InsProduct product;

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setProduct(InsProduct product) {
		this.product = product;
	}

	public InsProduct getProduct() {
		return this.product;
	}

}
