package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 分组查询模型
 *
 * @author auto create
 * @since 1.0, 2017-06-14 11:01:42
 */
public class QueryGroup extends AlipayObject {

	private static final long serialVersionUID = 7418848253513197658L;

	/**
	 * 分组id
	 */
	@ApiField("id")
	private String id;

	/**
	 * 分组中的圈人规则
	 */
	@ApiListField("label_rule")
	@ApiField("query_complex_label_rule")
	private List<QueryComplexLabelRule> labelRule;

	/**
	 * 用户分组名称
	 */
	@ApiField("name")
	private String name;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<QueryComplexLabelRule> getLabelRule() {
		return this.labelRule;
	}

	public void setLabelRule(List<QueryComplexLabelRule> labelRule) {
		this.labelRule = labelRule;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
