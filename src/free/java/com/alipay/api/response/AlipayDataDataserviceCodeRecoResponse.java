package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayCodeRecoResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.data.dataservice.code.reco response.
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:26:43
 */
public class AlipayDataDataserviceCodeRecoResponse extends AlipayResponse {

	private static final long serialVersionUID = 3321521247272599473L;

	/**
	 * 识别结果
	 */
	@ApiField("result")
	private AlipayCodeRecoResult result;

	public void setResult(AlipayCodeRecoResult result) {
		this.result = result;
	}

	public AlipayCodeRecoResult getResult() {
		return this.result;
	}

}
