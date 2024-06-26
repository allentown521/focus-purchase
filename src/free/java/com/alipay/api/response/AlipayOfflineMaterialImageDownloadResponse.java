package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.offline.material.image.download response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 11:37:33
 */
public class AlipayOfflineMaterialImageDownloadResponse extends AlipayResponse {

	private static final long serialVersionUID = 3512323782641939289L;

	/**
	 * 图片地址列表，按入参id顺序返回，如果某个id转化失败，则用空字符占位
	 */
	@ApiListField("image_urls")
	@ApiField("string")
	private List<String> imageUrls;

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public List<String> getImageUrls() {
		return this.imageUrls;
	}

}
