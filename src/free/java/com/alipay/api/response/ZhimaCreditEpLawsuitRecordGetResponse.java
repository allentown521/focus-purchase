package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.LawsuitRecord;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.lawsuit.record.get response.
 *
 * @author auto create
 * @since 1.0, 2017-11-02 14:03:22
 */
public class ZhimaCreditEpLawsuitRecordGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 3317213627255757398L;

	/**
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/**
	 * 企业涉诉记录
	 */
	@ApiField("lawsuit_record")
	private LawsuitRecord lawsuitRecord;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public String getBizNo() {
		return this.bizNo;
	}

	public void setLawsuitRecord(LawsuitRecord lawsuitRecord) {
		this.lawsuitRecord = lawsuitRecord;
	}

	public LawsuitRecord getLawsuitRecord() {
		return this.lawsuitRecord;
	}

}
