package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SignTaskResult;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.security.prod.signature.task.apply response.
 *
 * @author auto create
 * @since 1.0, 2017-12-20 15:24:35
 */
public class AlipaySecurityProdSignatureTaskApplyResponse extends AlipayResponse {

	private static final long serialVersionUID = 3426956591329655495L;

	/**
	 * 签约订单id，关联了若干个签约任务id。
	 */
	@ApiField("order_id")
	private String orderId;

	/**
	 * 签约认证任务列表
	 */
	@ApiListField("task_list")
	@ApiField("sign_task_result")
	private List<SignTaskResult> taskList;

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setTaskList(List<SignTaskResult> taskList) {
		this.taskList = taskList;
	}

	public List<SignTaskResult> getTaskList() {
		return this.taskList;
	}

}
