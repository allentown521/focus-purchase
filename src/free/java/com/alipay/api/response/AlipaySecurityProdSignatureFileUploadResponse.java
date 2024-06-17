package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.signature.file.upload response.
 *
 * @author auto create
 * @since 1.0, 2017-12-20 15:24:53
 */
public class AlipaySecurityProdSignatureFileUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 6311115989363439411L;

	/**
	 * 文件唯一标识，用于apply接口传入
	 */
	@ApiField("oss_file_id")
	private String ossFileId;

	public void setOssFileId(String ossFileId) {
		this.ossFileId = ossFileId;
	}

	public String getOssFileId() {
		return this.ossFileId;
	}

}
