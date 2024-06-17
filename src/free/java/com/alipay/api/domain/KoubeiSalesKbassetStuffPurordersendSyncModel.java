package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 采购单发货通知接口
 *
 * @author auto create
 * @since 1.0, 2017-11-21 17:40:07
 */
public class KoubeiSalesKbassetStuffPurordersendSyncModel extends AlipayObject {

	private static final long serialVersionUID = 1111181423527448268L;

	/**
	 * 供应商同步的发货信息及物流信息记录（最多100条）
	 */
	@ApiListField("purchase_order_sends")
	@ApiField("access_purchase_order_send")
	private List<AccessPurchaseOrderSend> purchaseOrderSends;

	public List<AccessPurchaseOrderSend> getPurchaseOrderSends() {
		return this.purchaseOrderSends;
	}

	public void setPurchaseOrderSends(List<AccessPurchaseOrderSend> purchaseOrderSends) {
		this.purchaseOrderSends = purchaseOrderSends;
	}

}
