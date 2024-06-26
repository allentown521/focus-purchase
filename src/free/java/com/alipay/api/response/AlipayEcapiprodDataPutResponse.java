package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ecapiprod.data.put response.
 *
 * @author auto create
 * @since 1.0, 2015-04-02 16:45:23
 */
public class AlipayEcapiprodDataPutResponse extends AlipayResponse {

	private static final long serialVersionUID = 8733526437223931726L;

	/**
	 * 数据版本
	 */
	@ApiField("data_version")
	private String dataVersion;

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

}
