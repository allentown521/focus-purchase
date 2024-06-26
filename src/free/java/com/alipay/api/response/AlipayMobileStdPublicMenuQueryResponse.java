package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.std.public.menu.query response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 20:30:12
 */
public class AlipayMobileStdPublicMenuQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1411939984884846753L;

	/**
	 * 所有菜单列表json串
	 */
	@ApiField("all_menu_list")
	private String allMenuList;

	public void setAllMenuList(String allMenuList) {
		this.allMenuList = allMenuList;
	}

	public String getAllMenuList() {
		return this.allMenuList;
	}

}
