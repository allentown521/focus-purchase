package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CustomReportCondition;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.data.customreport.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:35:21
 */
public class KoubeiMarketingDataCustomreportBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8841185958475511292L;

	/**
	 * 分页输出自定义开放数据规则列表
	 */
	@ApiListField("report_condition_list")
	@ApiField("custom_report_condition")
	private List<CustomReportCondition> reportConditionList;

	public void setReportConditionList(List<CustomReportCondition> reportConditionList) {
		this.reportConditionList = reportConditionList;
	}

	public List<CustomReportCondition> getReportConditionList() {
		return this.reportConditionList;
	}

}
