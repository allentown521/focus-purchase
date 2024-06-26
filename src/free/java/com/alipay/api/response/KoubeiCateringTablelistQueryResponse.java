package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TableInfoResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.catering.tablelist.query response.
 *
 * @author auto create
 * @since 1.0, 2017-06-26 14:14:12
 */
public class KoubeiCateringTablelistQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7137344261551382538L;

	/**
	 * 返回tablelistresult列表
	 */
	@ApiField("tableinfo_result")
	private TableInfoResult tableinfoResult;

	public void setTableinfoResult(TableInfoResult tableinfoResult) {
		this.tableinfoResult = tableinfoResult;
	}

	public TableInfoResult getTableinfoResult() {
		return this.tableinfoResult;
	}

}
