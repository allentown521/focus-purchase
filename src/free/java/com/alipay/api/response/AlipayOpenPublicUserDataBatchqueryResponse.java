package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.UserAnalysisData;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.user.data.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 15:05:24
 */
public class AlipayOpenPublicUserDataBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8465466885623386657L;

	/**
	 * 用户分析数据
	 */
	@ApiListField("data_list")
	@ApiField("user_analysis_data")
	private List<UserAnalysisData> dataList;

	public void setDataList(List<UserAnalysisData> dataList) {
		this.dataList = dataList;
	}

	public List<UserAnalysisData> getDataList() {
		return this.dataList;
	}

}
