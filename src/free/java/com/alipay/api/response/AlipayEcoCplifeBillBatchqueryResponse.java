package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CPBillResultSet;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.eco.cplife.bill.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-06-09 20:13:42
 */
public class AlipayEcoCplifeBillBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2689861191798448265L;

	/**
	 * 若查询到符合条件的账单条目，返回结果集
	 */
	@ApiListField("bill_result_set")
	@ApiField("c_p_bill_result_set")
	private List<CPBillResultSet> billResultSet;

	/**
	 * 当前页码
	 */
	@ApiField("current_page_num")
	private Long currentPageNum;

	/**
	 * 符合条件的总结果数
	 */
	@ApiField("total_bill_count")
	private Long totalBillCount;

	public void setBillResultSet(List<CPBillResultSet> billResultSet) {
		this.billResultSet = billResultSet;
	}

	public List<CPBillResultSet> getBillResultSet() {
		return this.billResultSet;
	}

	public void setCurrentPageNum(Long currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public Long getCurrentPageNum() {
		return this.currentPageNum;
	}

	public void setTotalBillCount(Long totalBillCount) {
		this.totalBillCount = totalBillCount;
	}

	public Long getTotalBillCount() {
		return this.totalBillCount;
	}

}
