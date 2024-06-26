package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.beacon.device.delete response.
 *
 * @author auto create
 * @since 1.0, 2017-02-28 11:14:55
 */
public class AlipayMobileBeaconDeviceDeleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 1645418871349164384L;

	/**
	 * 操作返回码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 请求处理结果
	 */
	@ApiField("msg")
	private String msg;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
