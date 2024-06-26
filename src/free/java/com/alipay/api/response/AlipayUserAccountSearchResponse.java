package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AccountRecord;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.user.account.search response.
 *
 * @author auto create
 * @since 1.0, 2016-08-11 18:02:23
 */
public class AlipayUserAccountSearchResponse extends AlipayResponse {

	private static final long serialVersionUID = 2859543492172597488L;

	/**
	 * 支付宝用户账务明细信息
	 */
	@ApiListField("account_records")
	@ApiField("account_record")
	private List<AccountRecord> accountRecords;

	/**
	 * 总页面数
	 */
	@ApiField("total_pages")
	private Long totalPages;

	/**
	 * 总记录数
	 */
	@ApiField("total_results")
	private Long totalResults;

	public void setAccountRecords(List<AccountRecord> accountRecords) {
		this.accountRecords = accountRecords;
	}

	public List<AccountRecord> getAccountRecords() {
		return this.accountRecords;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalPages() {
		return this.totalPages;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public Long getTotalResults() {
		return this.totalResults;
	}

}
