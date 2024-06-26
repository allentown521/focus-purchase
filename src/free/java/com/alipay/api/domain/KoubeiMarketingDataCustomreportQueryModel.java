package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 自定义数据报表数据查询接口
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:30:06
 */
public class KoubeiMarketingDataCustomreportQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5832524883394263146L;

	/**
	 * 规则KEY
	 */
	@ApiField("condition_key")
	private String conditionKey;

	/**
	 * 额外增加的查询过滤条件
	 */
	@ApiListField("filter_tags")
	@ApiField("filter_tag")
	private List<FilterTag> filterTags;

	/**
	 * 一次拉多少条
	 */
	@ApiField("max_count")
	private String maxCount;

	public String getConditionKey() {
		return this.conditionKey;
	}

	public void setConditionKey(String conditionKey) {
		this.conditionKey = conditionKey;
	}

	public List<FilterTag> getFilterTags() {
		return this.filterTags;
	}

	public void setFilterTags(List<FilterTag> filterTags) {
		this.filterTags = filterTags;
	}

	public String getMaxCount() {
		return this.maxCount;
	}

	public void setMaxCount(String maxCount) {
		this.maxCount = maxCount;
	}

}
