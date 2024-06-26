package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 配送指令接收反馈接口
 *
 * @author auto create
 * @since 1.0, 2018-06-26 14:22:44
 */
public class AntMerchantExpandAssetdeliveryAssignSyncModel extends AlipayObject {

	private static final long serialVersionUID = 5793115963865123945L;

	/**
	 * 配送指令接收反馈，最多200条
	 */
	@ApiListField("delivery_results")
	@ApiField("asset_result")
	private List<AssetResult> deliveryResults;

	public List<AssetResult> getDeliveryResults() {
		return this.deliveryResults;
	}

	public void setDeliveryResults(List<AssetResult> deliveryResults) {
		this.deliveryResults = deliveryResults;
	}

}
