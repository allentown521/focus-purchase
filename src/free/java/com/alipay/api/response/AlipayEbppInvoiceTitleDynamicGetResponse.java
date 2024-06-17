package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.InvoiceTitleModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ebpp.invoice.title.dynamic.get response.
 *
 * @author auto create
 * @since 1.0, 2018-07-02 10:30:28
 */
public class AlipayEbppInvoiceTitleDynamicGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 1696241833526684291L;

	/**
	 * 发票抬头
	 */
	@ApiField("title")
	private InvoiceTitleModel title;

	public void setTitle(InvoiceTitleModel title) {
		this.title = title;
	}

	public InvoiceTitleModel getTitle() {
		return this.title;
	}

}
