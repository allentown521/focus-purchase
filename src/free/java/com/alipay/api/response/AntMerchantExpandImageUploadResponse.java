package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: ant.merchant.expand.image.upload response.
 *
 * @author auto create
 * @since 1.0, 2018-05-23 11:30:21
 */
public class AntMerchantExpandImageUploadResponse extends AlipayResponse {

	private static final long serialVersionUID = 5454217979228595525L;

	/**
	 * 图片在sfs中的标识
	 */
	@ApiField("image_id")
	private String imageId;

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageId() {
		return this.imageId;
	}

}
