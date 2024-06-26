package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 口碑零售商户信息查询
 *
 * @author auto create
 * @since 1.0, 2018-06-05 10:58:30
 */
public class KoubeiRetailWmsPartnerQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5131561946831182597L;

	/**
	 * 操作上下文
	 */
	@ApiField("operate_context")
	private OperateContext operateContext;

	/**
	 * 商户ID，限制批量查询100个ID
	 */
	@ApiListField("partner_ids")
	@ApiField("string")
	private List<String> partnerIds;

	public OperateContext getOperateContext() {
		return this.operateContext;
	}

	public void setOperateContext(OperateContext operateContext) {
		this.operateContext = operateContext;
	}

	public List<String> getPartnerIds() {
		return this.partnerIds;
	}

	public void setPartnerIds(List<String> partnerIds) {
		this.partnerIds = partnerIds;
	}

}
