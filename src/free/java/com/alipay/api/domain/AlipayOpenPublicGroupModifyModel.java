package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 用户分组修改接口
 *
 * @author auto create
 * @since 1.0, 2018-05-11 19:06:21
 */
public class AlipayOpenPublicGroupModifyModel extends AlipayObject {

	private static final long serialVersionUID = 7267575241759316868L;

	/**
	 * 分组ID，整型值
	 */
	@ApiField("group_id")
	private String groupId;

	/**
	 * 标签规则，满足该规则的粉丝将被圈定，标签id不能重复
	 */
	@ApiListField("label_rule")
	@ApiField("complex_label_rule")
	private List<ComplexLabelRule> labelRule;

	/**
	 * 分组名称，仅支持中文、字母、数字、下划线的组合。
	 */
	@ApiField("name")
	private String name;

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<ComplexLabelRule> getLabelRule() {
		return this.labelRule;
	}

	public void setLabelRule(List<ComplexLabelRule> labelRule) {
		this.labelRule = labelRule;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
