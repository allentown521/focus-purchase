package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 生产指令接收反馈接口
 *
 * @author auto create
 * @since 1.0, 2018-06-26 14:22:59
 */
public class AntMerchantExpandAssetproduceAssignSyncModel extends AlipayObject {

	private static final long serialVersionUID = 3177264474563697416L;

	/**
	 * 生产指令接收情况，最多200条
	 */
	@ApiListField("asset_results")
	@ApiField("asset_result")
	private List<AssetResult> assetResults;

	public List<AssetResult> getAssetResults() {
		return this.assetResults;
	}

	public void setAssetResults(List<AssetResult> assetResults) {
		this.assetResults = assetResults;
	}

}
