package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlisisReport;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.data.alisis.report.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-05-03 09:40:58
 */
public class KoubeiMarketingDataAlisisReportBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6387552936236859486L;

	/**
	 * 报表列表信息
	 */
	@ApiListField("report_list")
	@ApiField("alisis_report")
	private List<AlisisReport> reportList;

	/**
	 * 总记录数
	 */
	@ApiField("total_count")
	private String totalCount;

	public void setReportList(List<AlisisReport> reportList) {
		this.reportList = reportList;
	}

	public List<AlisisReport> getReportList() {
		return this.reportList;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalCount() {
		return this.totalCount;
	}

}
