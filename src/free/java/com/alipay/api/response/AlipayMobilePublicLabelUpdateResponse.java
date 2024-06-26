package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.label.update response.
 *
 * @author auto create
 * @since 1.0, 2016-07-29 19:58:24
 */
public class AlipayMobilePublicLabelUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 1534373536442616321L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 标签编号
	 */
	@ApiField("id")
	private Long id;

	/**
	 * 结果信息
	 */
	@ApiField("msg")
	private String msg;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
