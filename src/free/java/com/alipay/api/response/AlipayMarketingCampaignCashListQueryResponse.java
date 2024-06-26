package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CashCampaignInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.marketing.campaign.cash.list.query response.
 *
 * @author auto create
 * @since 1.0, 2017-07-14 11:53:33
 */
public class AlipayMarketingCampaignCashListQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1545519395477919836L;

	/**
	 * 活动列表
	 */
	@ApiListField("camp_list")
	@ApiField("cash_campaign_info")
	private List<CashCampaignInfo> campList;

	/**
	 * 分页的页码,起始从1开始
	 */
	@ApiField("page_index")
	private String pageIndex;

	/**
	 * 分页每页大小
	 */
	@ApiField("page_size")
	private String pageSize;

	/**
	 * 活动总个数
	 */
	@ApiField("total_size")
	private String totalSize;

	public void setCampList(List<CashCampaignInfo> campList) {
		this.campList = campList;
	}

	public List<CashCampaignInfo> getCampList() {
		return this.campList;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageIndex() {
		return this.pageIndex;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageSize() {
		return this.pageSize;
	}

	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}

	public String getTotalSize() {
		return this.totalSize;
	}

}
