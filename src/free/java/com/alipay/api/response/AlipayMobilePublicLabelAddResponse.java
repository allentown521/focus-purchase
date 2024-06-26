package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.label.add response.
 *
 * @author auto create
 * @since 1.0, 2016-07-29 20:00:29
 */
public class AlipayMobilePublicLabelAddResponse extends AlipayResponse {

	private static final long serialVersionUID = 3661969955516286258L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 标签编码
	 */
	@ApiField("id")
	private Long id;

	/**
	 * 结果信息
	 */
	@ApiField("msg")
	private String msg;

	/**
	 * 标签名称
	 */
	@ApiField("name")
	private String name;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
