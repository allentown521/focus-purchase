package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 回传码物料码值
 *
 * @author auto create
 * @since 1.0, 2017-11-21 17:40:30
 */
public class KoubeiSalesKbassetStuffQrcodereturnSyncModel extends AlipayObject {

	private static final long serialVersionUID = 6799574217545729895L;

	/**
	 * 供应商回传码物料码值记录（最多200条）
	 */
	@ApiListField("return_qrcodes")
	@ApiField("access_return_qrcode")
	private List<AccessReturnQrcode> returnQrcodes;

	public List<AccessReturnQrcode> getReturnQrcodes() {
		return this.returnQrcodes;
	}

	public void setReturnQrcodes(List<AccessReturnQrcode> returnQrcodes) {
		this.returnQrcodes = returnQrcodes;
	}

}
