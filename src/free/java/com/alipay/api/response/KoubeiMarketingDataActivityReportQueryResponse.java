package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.data.activity.report.query response.
 *
 * @author auto create
 * @since 1.0, 2017-12-07 16:53:34
 */
public class KoubeiMarketingDataActivityReportQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6461816794296118566L;

	/**
	 * 报表
	 */
	@ApiField("report_data")
	private String reportData;

	public void setReportData(String reportData) {
		this.reportData = reportData;
	}

	public String getReportData() {
		return this.reportData;
	}

}
