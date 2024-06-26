package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 口碑零售供应商信息查询
 *
 * @author auto create
 * @since 1.0, 2018-06-05 10:58:43
 */
public class KoubeiRetailWmsSupplierQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1185735333159691496L;

	/**
	 * 操作上下文
	 */
	@ApiField("operate_context")
	private OperateContext operateContext;

	/**
	 * 供应商ID，限制批量查询100个ID
	 */
	@ApiListField("supplier_ids")
	@ApiField("string")
	private List<String> supplierIds;

	public OperateContext getOperateContext() {
		return this.operateContext;
	}

	public void setOperateContext(OperateContext operateContext) {
		this.operateContext = operateContext;
	}

	public List<String> getSupplierIds() {
		return this.supplierIds;
	}

	public void setSupplierIds(List<String> supplierIds) {
		this.supplierIds = supplierIds;
	}

}
