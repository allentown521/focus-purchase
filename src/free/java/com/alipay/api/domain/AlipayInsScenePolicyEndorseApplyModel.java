package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 保险批单申请接口
 *
 * @author auto create
 * @since 1.0, 2018-04-03 11:28:52
 */
public class AlipayInsScenePolicyEndorseApplyModel extends AlipayObject {

	private static final long serialVersionUID = 3524848679997149173L;

	/**
	 * 批单项列表
	 */
	@ApiListField("endorse_items")
	@ApiField("ins_endorse_item")
	private List<InsEndorseItem> endorseItems;

	/**
	 * 商户生成的批改请求单号【幂等字段】
	 */
	@ApiField("out_request_no")
	private String outRequestNo;

	/**
	 * 保单凭证号;蚂蚁保险平台生成的保单凭证号,用户可以通过此单号去保险公司查询保单信息.
	 */
	@ApiField("policy_no")
	private String policyNo;

	/**
	 * 批单来源
	 */
	@ApiField("source")
	private String source;

	public List<InsEndorseItem> getEndorseItems() {
		return this.endorseItems;
	}

	public void setEndorseItems(List<InsEndorseItem> endorseItems) {
		this.endorseItems = endorseItems;
	}

	public String getOutRequestNo() {
		return this.outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
