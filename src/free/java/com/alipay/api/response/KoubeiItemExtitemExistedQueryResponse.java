package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.item.extitem.existed.query response.
 *
 * @author auto create
 * @since 1.0, 2016-07-06 10:48:15
 */
public class KoubeiItemExtitemExistedQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3886951356228178659L;

	/**
	 * 商品库中存在的商品编码
	 */
	@ApiListField("existed_list")
	@ApiField("string")
	private List<String> existedList;

	public void setExistedList(List<String> existedList) {
		this.existedList = existedList;
	}

	public List<String> getExistedList() {
		return this.existedList;
	}

}
