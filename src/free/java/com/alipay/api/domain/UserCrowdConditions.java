package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 智慧餐厅用户规则集合
 *
 * @author auto create
 * @since 1.0, 2018-04-03 21:31:17
 */
public class UserCrowdConditions extends AlipayObject {

	private static final long serialVersionUID = 1615341818979471345L;

	/**
	 * 最爱这家店的人
	 */
	@ApiField("crowd_group_id")
	private String crowdGroupId;

	/**
	 * 用户群组描述
	 */
	@ApiField("describe")
	private String describe;

	/**
	 * 命中用户规则集合
	 */
	@ApiListField("hit_crowd_conditons")
	@ApiField("condition_item_pattern")
	private List<ConditionItemPattern> hitCrowdConditons;

	public String getCrowdGroupId() {
		return this.crowdGroupId;
	}

	public void setCrowdGroupId(String crowdGroupId) {
		this.crowdGroupId = crowdGroupId;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public List<ConditionItemPattern> getHitCrowdConditons() {
		return this.hitCrowdConditons;
	}

	public void setHitCrowdConditons(List<ConditionItemPattern> hitCrowdConditons) {
		this.hitCrowdConditons = hitCrowdConditons;
	}

}
