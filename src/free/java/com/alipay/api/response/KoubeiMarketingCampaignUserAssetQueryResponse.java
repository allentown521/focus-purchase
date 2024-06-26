package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.VoucherDetailInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.marketing.campaign.user.asset.query response.
 *
 * @author auto create
 * @since 1.0, 2018-03-21 15:19:49
 */
public class KoubeiMarketingCampaignUserAssetQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7564689168971946129L;

	/**
	 * 券资产详情信息
	 */
	@ApiListField("voucher_asset_list")
	@ApiField("voucher_detail_info")
	private List<VoucherDetailInfo> voucherAssetList;

	/**
	 * 券资产数量
	 */
	@ApiField("voucher_asset_num")
	private Long voucherAssetNum;

	public void setVoucherAssetList(List<VoucherDetailInfo> voucherAssetList) {
		this.voucherAssetList = voucherAssetList;
	}

	public List<VoucherDetailInfo> getVoucherAssetList() {
		return this.voucherAssetList;
	}

	public void setVoucherAssetNum(Long voucherAssetNum) {
		this.voucherAssetNum = voucherAssetNum;
	}

	public Long getVoucherAssetNum() {
		return this.voucherAssetNum;
	}

}
