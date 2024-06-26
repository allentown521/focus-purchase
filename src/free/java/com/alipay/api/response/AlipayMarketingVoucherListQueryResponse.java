package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.VoucherLiteInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.marketing.voucher.list.query response.
 *
 * @author auto create
 * @since 1.0, 2018-06-20 18:11:14
 */
public class AlipayMarketingVoucherListQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8351654262588437657L;

	/**
	 * 券列表，一定不为null，但是size可以为0
	 */
	@ApiListField("vouchers")
	@ApiField("voucher_lite_info")
	private List<VoucherLiteInfo> vouchers;

	public void setVouchers(List<VoucherLiteInfo> vouchers) {
		this.vouchers = vouchers;
	}

	public List<VoucherLiteInfo> getVouchers() {
		return this.vouchers;
	}

}
