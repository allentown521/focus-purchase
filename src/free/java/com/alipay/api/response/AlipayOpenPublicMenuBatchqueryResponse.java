package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.QueryMenu;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.menu.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2017-10-19 15:33:41
 */
public class AlipayOpenPublicMenuBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1539514784266373614L;

	/**
	 * 菜单数量，包括默认菜单和个性化菜单
	 */
	@ApiField("count")
	private String count;

	/**
	 * 菜单列表
	 */
	@ApiListField("menus")
	@ApiField("query_menu")
	private List<QueryMenu> menus;

	public void setCount(String count) {
		this.count = count;
	}

	public String getCount() {
		return this.count;
	}

	public void setMenus(List<QueryMenu> menus) {
		this.menus = menus;
	}

	public List<QueryMenu> getMenus() {
		return this.menus;
	}

}
