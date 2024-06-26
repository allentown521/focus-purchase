package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayHighValueCustomerResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.data.dataservice.userlevel.zrank.get response.
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:27:27
 */
public class AlipayDataDataserviceUserlevelZrankGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 3877569887952719182L;

	/**
	 * 活跃高价值用户返回
	 */
	@ApiField("result")
	private AlipayHighValueCustomerResult result;

	public void setResult(AlipayHighValueCustomerResult result) {
		this.result = result;
	}

	public AlipayHighValueCustomerResult getResult() {
		return this.result;
	}

}
