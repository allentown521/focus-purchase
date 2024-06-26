package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 阶梯优惠
 *
 * @author auto create
 * @since 1.0, 2017-03-03 16:47:49
 */
public class StagedDiscountDstCampPrizeModel extends AlipayObject {

	private static final long serialVersionUID = 6795597957297689632L;

	/**
	 * 折扣预算ID
	 */
	@ApiField("budget_id")
	private String budgetId;

	/**
	 * 折扣幅度列表.
	 */
	@ApiListField("discount_rate_model_list")
	@ApiField("discount_rate_model")
	private List<DiscountRateModel> discountRateModelList;

	/**
	 * 奖品id
	 */
	@ApiField("id")
	private String id;

	/**
	 * 单次优惠上限(元)
	 */
	@ApiField("max_discount_amt")
	private String maxDiscountAmt;

	public String getBudgetId() {
		return this.budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public List<DiscountRateModel> getDiscountRateModelList() {
		return this.discountRateModelList;
	}

	public void setDiscountRateModelList(List<DiscountRateModel> discountRateModelList) {
		this.discountRateModelList = discountRateModelList;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaxDiscountAmt() {
		return this.maxDiscountAmt;
	}

	public void setMaxDiscountAmt(String maxDiscountAmt) {
		this.maxDiscountAmt = maxDiscountAmt;
	}

}
