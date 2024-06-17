package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 安全业务操作
 *
 * @author auto create
 * @since 1.0, 2016-03-02 10:47:05
 */
public class AlipaySecurityProdAlipaySecurityProdTestModel extends AlipayObject {

	private static final long serialVersionUID = 1266429355296862222L;

	/**
	 * ddd
	 */
	@ApiListField("cds")
	@ApiField("string")
	private List<String> cds;

	/**
	 * aaa
	 */
	@ApiField("ddd")
	private String ddd;

	public List<String> getCds() {
		return this.cds;
	}

	public void setCds(List<String> cds) {
		this.cds = cds;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}
