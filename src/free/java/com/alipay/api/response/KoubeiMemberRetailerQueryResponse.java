package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Retailer;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.member.retailer.query response.
 *
 * @author auto create
 * @since 1.0, 2018-01-12 10:59:05
 */
public class KoubeiMemberRetailerQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4655186477987191833L;

	/**
	 * 零售商信息列表
	 */
	@ApiListField("retailer_list")
	@ApiField("retailer")
	private List<Retailer> retailerList;

	public void setRetailerList(List<Retailer> retailerList) {
		this.retailerList = retailerList;
	}

	public List<Retailer> getRetailerList() {
		return this.retailerList;
	}

}
