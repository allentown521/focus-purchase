package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.RechargeBill;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.commerce.cityfacilitator.deposit.query response.
 *
 * @author auto create
 * @since 1.0, 2015-12-15 11:37:56
 */
public class AlipayCommerceCityfacilitatorDepositQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5827441467171765316L;

	/**
	 * 待圈存明细
	 */
	@ApiListField("recharge_bills")
	@ApiField("recharge_bill")
	private List<RechargeBill> rechargeBills;

	public void setRechargeBills(List<RechargeBill> rechargeBills) {
		this.rechargeBills = rechargeBills;
	}

	public List<RechargeBill> getRechargeBills() {
		return this.rechargeBills;
	}

}
