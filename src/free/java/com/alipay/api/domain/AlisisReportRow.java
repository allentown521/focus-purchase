package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 报表行对象
 *
 * @author auto create
 * @since 1.0, 2016-10-28 10:26:15
 */
public class AlisisReportRow extends AlipayObject {

	private static final long serialVersionUID = 7677237548714745862L;

	/**
	 * 报表行信息，每个对象是一列的数据
	 */
	@ApiListField("row_data")
	@ApiField("alisis_report_column")
	private List<AlisisReportColumn> rowData;

	public List<AlisisReportColumn> getRowData() {
		return this.rowData;
	}

	public void setRowData(List<AlisisReportColumn> rowData) {
		this.rowData = rowData;
	}

}
