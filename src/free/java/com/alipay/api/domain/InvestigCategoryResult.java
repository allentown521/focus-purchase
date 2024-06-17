package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 数据项的调查结果
 *
 * @author auto create
 * @since 1.0, 2017-05-31 13:44:00
 */
public class InvestigCategoryResult extends AlipayObject {

	private static final long serialVersionUID = 7791418911433322919L;

	/**
	 * 数据项Category
	 */
	@ApiField("category")
	private String category;

	/**
	 * 数据项对应的所有采集结果
	 */
	@ApiListField("category_result")
	@ApiField("investig_category_data")
	private List<InvestigCategoryData> categoryResult;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<InvestigCategoryData> getCategoryResult() {
		return this.categoryResult;
	}

	public void setCategoryResult(List<InvestigCategoryData> categoryResult) {
		this.categoryResult = categoryResult;
	}

}
