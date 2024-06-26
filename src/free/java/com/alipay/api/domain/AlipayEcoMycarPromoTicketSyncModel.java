package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ISV有新的卡券信息同步到车主服务平台
 *
 * @author auto create
 * @since 1.0, 2017-09-15 16:29:40
 */
public class AlipayEcoMycarPromoTicketSyncModel extends AlipayObject {

	private static final long serialVersionUID = 6559668798416795896L;

	/**
	 * 营销活动ID
	 */
	@ApiField("active_id")
	private String activeId;

	/**
	 * 需要同步的卡券信息
	 */
	@ApiListField("code_no_list")
	@ApiField("code_n_o_list")
	private List<CodeNOList> codeNoList;

	/**
	 * 卡券来源
	 */
	@ApiField("source_type")
	private String sourceType;

	public String getActiveId() {
		return this.activeId;
	}

	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}

	public List<CodeNOList> getCodeNoList() {
		return this.codeNoList;
	}

	public void setCodeNoList(List<CodeNOList> codeNoList) {
		this.codeNoList = codeNoList;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

}
