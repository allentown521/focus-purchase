package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 间连商户文件上传
 *
 * @author auto create
 * @since 1.0, 2017-09-23 20:47:16
 */
public class AntMerchantExpandIndirectAttachmentUploadModel extends AlipayObject {

	private static final long serialVersionUID = 7474255594843917966L;

	/**
	 * 商户附件信息
	 */
	@ApiListField("attachment_info")
	@ApiField("attachment_info")
	private List<AttachmentInfo> attachmentInfo;

	/**
	 * 备注信息
	 */
	@ApiField("memo")
	private String memo;

	/**
	 * 商户在支付宝入驻成功后，生成的支付宝内全局唯一的商户编号
	 */
	@ApiField("sub_merchant_id")
	private String subMerchantId;

	public List<AttachmentInfo> getAttachmentInfo() {
		return this.attachmentInfo;
	}

	public void setAttachmentInfo(List<AttachmentInfo> attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSubMerchantId() {
		return this.subMerchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

}
