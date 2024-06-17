package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Advert;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.advert.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-04-11 15:10:00
 */
public class AlipayOpenPublicAdvertBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1199526244269151264L;

	/**
	 * 广告位list ,目前只有一个广告位
	 */
	@ApiListField("advert_list")
	@ApiField("advert")
	private List<Advert> advertList;

	public void setAdvertList(List<Advert> advertList) {
		this.advertList = advertList;
	}

	public List<Advert> getAdvertList() {
		return this.advertList;
	}

}
