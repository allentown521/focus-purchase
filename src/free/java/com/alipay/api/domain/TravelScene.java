package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 出行营销场景
 *
 * @author auto create
 * @since 1.0, 2018-06-03 13:09:18
 */
public class TravelScene extends AlipayObject {

	private static final long serialVersionUID = 7552382362528674486L;

	/**
	 * 出行场景，综合体入参列表
	 */
	@ApiListField("data_list")
	@ApiField("travel_mall_request")
	private List<TravelMallRequest> dataList;

	public List<TravelMallRequest> getDataList() {
		return this.dataList;
	}

	public void setDataList(List<TravelMallRequest> dataList) {
		this.dataList = dataList;
	}

}
