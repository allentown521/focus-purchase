package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.edu.kt.student.modify response.
 *
 * @author auto create
 * @since 1.0, 2017-11-06 11:46:27
 */
public class AlipayEcoEduKtStudentModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 6496336419691716525L;

	/**
	 * Y：代表成功；N：代表失败
	 */
	@ApiField("status")
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
