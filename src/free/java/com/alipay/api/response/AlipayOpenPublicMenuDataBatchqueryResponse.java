package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MenuAnalysisData;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.menu.data.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 15:07:28
 */
public class AlipayOpenPublicMenuDataBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2749613463535153258L;

	/**
	 * 菜单分析数据列表
	 */
	@ApiListField("data_list")
	@ApiField("menu_analysis_data")
	private List<MenuAnalysisData> dataList;

	public void setDataList(List<MenuAnalysisData> dataList) {
		this.dataList = dataList;
	}

	public List<MenuAnalysisData> getDataList() {
		return this.dataList;
	}

}
