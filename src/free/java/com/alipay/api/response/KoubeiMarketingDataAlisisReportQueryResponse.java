package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlisisReportRow;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.data.alisis.report.query response.
 *
 * @author auto create
 * @since 1.0, 2018-05-03 09:41:08
 */
public class KoubeiMarketingDataAlisisReportQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2182378849631832614L;

	/**
	 * 报表数据
	 */
	@ApiListField("report_data")
	@ApiField("alisis_report_row")
	private List<AlisisReportRow> reportData;

	public void setReportData(List<AlisisReportRow> reportData) {
		this.reportData = reportData;
	}

	public List<AlisisReportRow> getReportData() {
		return this.reportData;
	}

}
