package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.pcredit.loan.refund.create response.
 *
 * @author auto create
 * @since 1.0, 2017-08-15 19:31:13
 */
public class AlipayPcreditLoanRefundCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 8829427671711652827L;

	/**
	 * 受理的还款申请单号
	 */
	@ApiField("loan_repay_no")
	private String loanRepayNo;

	public void setLoanRepayNo(String loanRepayNo) {
		this.loanRepayNo = loanRepayNo;
	}

	public String getLoanRepayNo() {
		return this.loanRepayNo;
	}

}
