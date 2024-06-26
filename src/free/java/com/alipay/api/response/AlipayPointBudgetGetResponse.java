package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.point.budget.get response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 18:54:17
 */
public class AlipayPointBudgetGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 2356449968377861636L;

	/**
	 * 还可以发放的集分宝个数
	 */
	@ApiField("budget_amount")
	private Long budgetAmount;

	public void setBudgetAmount(Long budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public Long getBudgetAmount() {
		return this.budgetAmount;
	}

}
