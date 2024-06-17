package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 券详情描述
 *
 * @author auto create
 * @since 1.0, 2016-06-23 17:38:07
 */
public class VoucherTermInfo extends AlipayObject {

	private static final long serialVersionUID = 4869814267175129966L;

	/**
	 * 描述信息
	 */
	@ApiListField("descriptions")
	@ApiField("string")
	private List<String> descriptions;

	/**
	 * 详情title
	 */
	@ApiField("title")
	private String title;

	public List<String> getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
