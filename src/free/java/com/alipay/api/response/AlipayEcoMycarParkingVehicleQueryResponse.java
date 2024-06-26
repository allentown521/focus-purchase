package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.mycar.parking.vehicle.query response.
 *
 * @author auto create
 * @since 1.0, 2017-08-25 17:09:28
 */
public class AlipayEcoMycarParkingVehicleQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6444475863543441694L;

	/**
	 * 车牌信息（utf-8编码）
	 */
	@ApiField("car_number")
	private String carNumber;

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return this.carNumber;
	}

}
