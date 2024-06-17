package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 物料生产完成反馈接口
 *
 * @author auto create
 * @since 1.0, 2018-06-26 14:22:07
 */
public class AntMerchantExpandAssetproduceCompleteSyncModel extends AlipayObject {

	private static final long serialVersionUID = 7217637461493122317L;

	/**
	 * 物料生产单完成后指定物流信息
	 */
	@ApiListField("asset_produce_details")
	@ApiField("item_delivery_detail")
	private List<ItemDeliveryDetail> assetProduceDetails;

	public List<ItemDeliveryDetail> getAssetProduceDetails() {
		return this.assetProduceDetails;
	}

	public void setAssetProduceDetails(List<ItemDeliveryDetail> assetProduceDetails) {
		this.assetProduceDetails = assetProduceDetails;
	}

}
