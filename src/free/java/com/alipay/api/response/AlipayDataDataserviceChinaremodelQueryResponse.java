package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayChinareModelResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.data.dataservice.chinaremodel.query response.
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:27:48
 */
public class AlipayDataDataserviceChinaremodelQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8815255696124366294L;

	/**
	 * 中再核保模型查询结果
	 */
	@ApiField("result")
	private AlipayChinareModelResult result;

	public void setResult(AlipayChinareModelResult result) {
		this.result = result;
	}

	public AlipayChinareModelResult getResult() {
		return this.result;
	}

}
