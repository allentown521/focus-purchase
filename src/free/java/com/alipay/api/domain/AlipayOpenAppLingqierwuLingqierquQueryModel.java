package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 零七二五
 *
 * @author auto create
 * @since 1.0, 2017-07-25 08:39:52
 */
public class AlipayOpenAppLingqierwuLingqierquQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5756744653211595696L;

	/**
	 * 12
	 */
	@ApiListField("test")
	@ApiField("string")
	private List<String> test;

	public List<String> getTest() {
		return this.test;
	}

	public void setTest(List<String> test) {
		this.test = test;
	}

}