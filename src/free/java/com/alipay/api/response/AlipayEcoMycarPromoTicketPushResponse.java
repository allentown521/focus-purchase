package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.promo.ticket.push response.
 *
 * @author auto create
 * @since 1.0, 2017-09-15 16:29:58
 */
public class AlipayEcoMycarPromoTicketPushResponse extends AlipayResponse {

	private static final long serialVersionUID = 3511327192234669572L;

	/**
	 * 处理结果返回码
	 */
	@ApiField("sp_apply_no")
	private String spApplyNo;

	public void setSpApplyNo(String spApplyNo) {
		this.spApplyNo = spApplyNo;
	}

	public String getSpApplyNo() {
		return this.spApplyNo;
	}

}
