package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TradeRecord;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.user.trade.search response.
 *
 * @author auto create
 * @since 1.0, 2018-03-14 11:11:45
 */
public class AlipayUserTradeSearchResponse extends AlipayResponse {

	private static final long serialVersionUID = 4718759712645412936L;

	/**
	 * 总页数
	 */
	@ApiField("total_pages")
	private String totalPages;

	/**
	 * 总记录数
	 */
	@ApiField("total_results")
	private String totalResults;

	/**
	 * 交易记录列表
	 */
	@ApiListField("trade_records")
	@ApiField("trade_record")
	private List<TradeRecord> tradeRecords;

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getTotalPages() {
		return this.totalPages;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getTotalResults() {
		return this.totalResults;
	}

	public void setTradeRecords(List<TradeRecord> tradeRecords) {
		this.tradeRecords = tradeRecords;
	}

	public List<TradeRecord> getTradeRecords() {
		return this.tradeRecords;
	}

}
