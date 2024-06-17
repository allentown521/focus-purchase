package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.cplife.bill.batch.upload response.
 *
 * @author auto create
 * @since 1.0, 2018-06-09 20:14:19
 */
public class AlipayEcoCplifeBillBatchUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 2256711678623822946L;

	/**
	 * 成功导入所有条目集合中的条目，则回传请求中的批次号
	 */
	@ApiField("batch_id")
	private String batchId;

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchId() {
		return this.batchId;
	}

}
