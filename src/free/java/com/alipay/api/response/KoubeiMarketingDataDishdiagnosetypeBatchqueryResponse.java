package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ItemDiagnoseType;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.data.dishdiagnosetype.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2017-10-10 19:25:38
 */
public class KoubeiMarketingDataDishdiagnosetypeBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1745825584119365347L;

	/**
	 * 菜品类型list
	 */
	@ApiListField("item_diagnose_type_list")
	@ApiField("item_diagnose_type")
	private List<ItemDiagnoseType> itemDiagnoseTypeList;

	public void setItemDiagnoseTypeList(List<ItemDiagnoseType> itemDiagnoseTypeList) {
		this.itemDiagnoseTypeList = itemDiagnoseTypeList;
	}

	public List<ItemDiagnoseType> getItemDiagnoseTypeList() {
		return this.itemDiagnoseTypeList;
	}

}
