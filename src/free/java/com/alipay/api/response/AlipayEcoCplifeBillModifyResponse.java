package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CPAliveBillEntrySet;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.eco.cplife.bill.modify response.
 *
 * @author auto create
 * @since 1.0, 2018-06-09 20:15:11
 */
public class AlipayEcoCplifeBillModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 6172272376648229374L;

	/**
	 * 不允许修改（支付中或者支付完成）的账单明细条目列表
	 */
	@ApiListField("alive_bill_entry_list")
	@ApiField("c_p_alive_bill_entry_set")
	private List<CPAliveBillEntrySet> aliveBillEntryList;

	public void setAliveBillEntryList(List<CPAliveBillEntrySet> aliveBillEntryList) {
		this.aliveBillEntryList = aliveBillEntryList;
	}

	public List<CPAliveBillEntrySet> getAliveBillEntryList() {
		return this.aliveBillEntryList;
	}

}
