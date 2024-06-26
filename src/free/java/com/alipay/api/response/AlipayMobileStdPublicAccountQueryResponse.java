package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PublicBindAccount;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.mobile.std.public.account.query response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 20:28:20
 */
public class AlipayMobileStdPublicAccountQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3246391622225337347L;

	/**
	 * 绑定账户列表
	 */
	@ApiListField("public_bind_accounts")
	@ApiField("public_bind_account")
	private List<PublicBindAccount> publicBindAccounts;

	public void setPublicBindAccounts(List<PublicBindAccount> publicBindAccounts) {
		this.publicBindAccounts = publicBindAccounts;
	}

	public List<PublicBindAccount> getPublicBindAccounts() {
		return this.publicBindAccounts;
	}

}
