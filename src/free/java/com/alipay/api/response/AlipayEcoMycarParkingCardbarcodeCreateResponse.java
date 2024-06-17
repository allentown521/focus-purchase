package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.QRcode;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.eco.mycar.parking.cardbarcode.create response.
 *
 * @author auto create
 * @since 1.0, 2017-08-25 17:10:39
 */
public class AlipayEcoMycarParkingCardbarcodeCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 4255129132964874725L;

	/**
	 * 停车车卡对应二维码列表
	 */
	@ApiListField("qrcodes")
	@ApiField("q_rcode")
	private List<QRcode> qrcodes;

	public void setQrcodes(List<QRcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public List<QRcode> getQrcodes() {
		return this.qrcodes;
	}

}
