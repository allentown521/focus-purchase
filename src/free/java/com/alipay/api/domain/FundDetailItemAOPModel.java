package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 主记录+对应资金明细信息列表模型
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:42
 */
public class FundDetailItemAOPModel extends AlipayObject {

	private static final long serialVersionUID = 7137267133758859394L;

	/**
	 * 主记录+对应资金明细信息模型列表
	 */
	@ApiListField("single_fund_detail_item_aopmodel_list")
	@ApiField("single_fund_detail_item_a_o_p_model")
	private List<SingleFundDetailItemAOPModel> singleFundDetailItemAopmodelList;

	public List<SingleFundDetailItemAOPModel> getSingleFundDetailItemAopmodelList() {
		return this.singleFundDetailItemAopmodelList;
	}

	public void setSingleFundDetailItemAopmodelList(List<SingleFundDetailItemAOPModel> singleFundDetailItemAopmodelList) {
		this.singleFundDetailItemAopmodelList = singleFundDetailItemAopmodelList;
	}

}
