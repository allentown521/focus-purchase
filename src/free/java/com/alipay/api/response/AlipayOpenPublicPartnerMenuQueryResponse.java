package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.partner.menu.query response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 20:23:59
 */
public class AlipayOpenPublicPartnerMenuQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3836179972357921439L;

	/**
	 * 服务窗菜单
	 */
	@ApiField("public_menu")
	private String publicMenu;

	public void setPublicMenu(String publicMenu) {
		this.publicMenu = publicMenu;
	}

	public String getPublicMenu() {
		return this.publicMenu;
	}

}
