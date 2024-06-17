package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 口碑零售生产厂商信息批量查询
 *
 * @author auto create
 * @since 1.0, 2018-06-05 10:56:50
 */
public class KoubeiRetailWmsProducerBatchqueryModel extends AlipayObject {

	private static final long serialVersionUID = 3329468642931152321L;

	/**
	 * 最多查询100个
	 */
	@ApiListField("producer_ids")
	@ApiField("string")
	private List<String> producerIds;

	public List<String> getProducerIds() {
		return this.producerIds;
	}

	public void setProducerIds(List<String> producerIds) {
		this.producerIds = producerIds;
	}

}
