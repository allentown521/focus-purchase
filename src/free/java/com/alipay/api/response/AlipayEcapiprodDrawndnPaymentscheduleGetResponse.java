package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PaymentSchedule;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.ecapiprod.drawndn.paymentschedule.get response.
 *
 * @author auto create
 * @since 1.0, 2016-03-29 11:34:20
 */
public class AlipayEcapiprodDrawndnPaymentscheduleGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 3835697718238226193L;

	/**
	 * 返回的支用还款计划集合
	 */
	@ApiListField("payment_schedules")
	@ApiField("payment_schedule")
	private List<PaymentSchedule> paymentSchedules;

	/**
	 * 唯一标识这次请求
	 */
	@ApiField("request_id")
	private String requestId;

	public void setPaymentSchedules(List<PaymentSchedule> paymentSchedules) {
		this.paymentSchedules = paymentSchedules;
	}

	public List<PaymentSchedule> getPaymentSchedules() {
		return this.paymentSchedules;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

}
