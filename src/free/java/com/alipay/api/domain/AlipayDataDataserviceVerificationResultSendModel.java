package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 验证结果反馈
 *
 * @author auto create
 * @since 1.0, 2018-01-29 16:50:13
 */
public class AlipayDataDataserviceVerificationResultSendModel extends AlipayObject {

	private static final long serialVersionUID = 1336731844487339468L;

	/**
	 * 部署单记录id
	 */
	@ApiField("record_id")
	private Long recordId;

	/**
	 * 验证结果列表
	 */
	@ApiListField("result_items")
	@ApiField("dx_verify_result_item")
	private List<DxVerifyResultItem> resultItems;

	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public List<DxVerifyResultItem> getResultItems() {
		return this.resultItems;
	}

	public void setResultItems(List<DxVerifyResultItem> resultItems) {
		this.resultItems = resultItems;
	}

}
