package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 云凤蝶空间详情模型
 *
 * @author auto create
 * @since 1.0, 2018-05-17 16:01:04
 */
public class FengdieSpaceDetailModel extends AlipayObject {

	private static final long serialVersionUID = 7161666128866631381L;

	/**
	 * 空间可用域名列表，云凤蝶站点发布后链接可用采用的域名
	 */
	@ApiListField("domains")
	@ApiField("fengdie_space_domains")
	private List<FengdieSpaceDomains> domains;

	/**
	 * 空间创建时间
	 */
	@ApiField("gmt_create")
	private String gmtCreate;

	/**
	 * 空间 ID
	 */
	@ApiField("space_id")
	private String spaceId;

	/**
	 * 空间标题
	 */
	@ApiField("title")
	private String title;

	public List<FengdieSpaceDomains> getDomains() {
		return this.domains;
	}

	public void setDomains(List<FengdieSpaceDomains> domains) {
		this.domains = domains;
	}

	public String getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
