package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 配送完成反馈详情
 *
 * @author auto create
 * @since 1.0, 2018-06-26 14:21:29
 */
public class AssetDeliveryDetail extends AlipayObject {

	private static final long serialVersionUID = 4461155848369696414L;

	/**
	 * 配送数量
	 */
	@ApiField("amount")
	private String amount;

	/**
	 * 配送订单ID
	 */
	@ApiField("assign_item_id")
	private String assignItemId;

	/**
	 * 由供应商自定义的分批反馈批次号，用于保持幂等，此值不传则需要按整批反馈.(由字母,数字,下划线组成)
	 */
	@ApiField("batch_no")
	private String batchNo;

	/**
	 * 物流单信息
	 */
	@ApiListField("logistics_infos")
	@ApiField("logistics_info")
	private List<LogisticsInfo> logisticsInfos;

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAssignItemId() {
		return this.assignItemId;
	}

	public void setAssignItemId(String assignItemId) {
		this.assignItemId = assignItemId;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public List<LogisticsInfo> getLogisticsInfos() {
		return this.logisticsInfos;
	}

	public void setLogisticsInfos(List<LogisticsInfo> logisticsInfos) {
		this.logisticsInfos = logisticsInfos;
	}

}
