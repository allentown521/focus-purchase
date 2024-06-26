package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mdata.tag.get response.
 *
 * @author auto create
 * @since 1.0, 2015-03-11 14:09:56
 */
public class AlipayMdataTagGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 2141224186787513754L;

	/**
	 * 查询到的标签值, JSON字符串
	 */
	@ApiField("tag_values")
	private String tagValues;

	public void setTagValues(String tagValues) {
		this.tagValues = tagValues;
	}

	public String getTagValues() {
		return this.tagValues;
	}

}
