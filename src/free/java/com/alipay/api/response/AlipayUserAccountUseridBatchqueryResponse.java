package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.user.account.userid.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2016-06-06 21:37:53
 */
public class AlipayUserAccountUseridBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7484288761773129746L;

	/**
	 * 用户列表
	 */
	@ApiListField("user_id_list")
	@ApiField("string")
	private List<String> userIdList;

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public List<String> getUserIdList() {
		return this.userIdList;
	}

}
