package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.data.customreport.save response.
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:35:49
 */
public class KoubeiMarketingDataCustomreportSaveResponse extends AlipayResponse {

	private static final long serialVersionUID = 4265883187176383481L;

	/**
	 * 自定义报表的规则ID
	 */
	@ApiField("condition_key")
	private String conditionKey;

	public void setConditionKey(String conditionKey) {
		this.conditionKey = conditionKey;
	}

	public String getConditionKey() {
		return this.conditionKey;
	}

}
