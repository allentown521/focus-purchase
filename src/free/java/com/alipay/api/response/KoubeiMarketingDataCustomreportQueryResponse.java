package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ReportDataItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.data.customreport.query response.
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:30:06
 */
public class KoubeiMarketingDataCustomreportQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5368197199473272313L;

	/**
	 * 数据量
	 */
	@ApiField("count")
	private String count;

	/**
	 * 满足自定义报表规则的报表数据
	 */
	@ApiListField("report_data")
	@ApiField("report_data_item")
	private List<ReportDataItem> reportData;

	public void setCount(String count) {
		this.count = count;
	}

	public String getCount() {
		return this.count;
	}

	public void setReportData(List<ReportDataItem> reportData) {
		this.reportData = reportData;
	}

	public List<ReportDataItem> getReportData() {
		return this.reportData;
	}

}
