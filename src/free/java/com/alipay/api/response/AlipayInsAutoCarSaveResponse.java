package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.auto.car.save response.
 *
 * @author auto create
 * @since 1.0, 2016-05-18 15:27:46
 */
public class AlipayInsAutoCarSaveResponse extends AlipayResponse {

	private static final long serialVersionUID = 5696334575374654581L;

	/**
	 * 车牌号
	 */
	@ApiField("car_no")
	private String carNo;

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarNo() {
		return this.carNo;
	}

}
