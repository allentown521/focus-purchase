package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.campaign.discount.budget.append response.
 *
 * @author auto create
 * @since 1.0, 2017-11-17 11:19:00
 */
public class AlipayMarketingCampaignDiscountBudgetAppendResponse extends AlipayResponse {

	private static final long serialVersionUID = 7883472951781953586L;

	/**
	 * 预算ID
	 */
	@ApiField("budget_id")
	private String budgetId;

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public String getBudgetId() {
		return this.budgetId;
	}

}
