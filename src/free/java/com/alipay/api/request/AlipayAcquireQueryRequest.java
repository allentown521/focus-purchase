package com.alipay.api.request;

import com.alipay.api.AlipayObject;
import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireQueryResponse;

import java.util.Map;

/**
 * ALIPAY API: alipay.acquire.query request
 *
 * @author auto create
 * @since 1.0, 2018-04-18 17:54:57
 */
public class AlipayAcquireQueryRequest implements AlipayRequest<AlipayAcquireQueryResponse> {

	private AlipayHashMap udfParams; // add user-defined text parameters
	private String apiVersion = "1.0";

	/**
	 * 支付宝合作商户网站唯一订单号
	 */
	private String outTradeNo;

	/**
	 * 该交易在支付宝系统中的交易流水号。
	 * 最短16位，最长64位。
	 * 如果同时传了out_trade_no和trade_no，则以trade_no为准。
	 */
	private String tradeNo;

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	private String terminalType;
	private String terminalInfo;
	private String prodCode;
	private String notifyUrl;
	private String returnUrl;
	private boolean needEncrypt = false;
	private AlipayObject bizModel = null;

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalType() {
		return this.terminalType;
	}

	public void setTerminalInfo(String terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public String getTerminalInfo() {
		return this.terminalInfo;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdCode() {
		return this.prodCode;
	}

	public String getApiMethodName() {
		return "alipay.acquire.query";
	}

	public Map<String, String> getTextParams() {
		AlipayHashMap txtParams = new AlipayHashMap();
		txtParams.put("out_trade_no", this.outTradeNo);
		txtParams.put("trade_no", this.tradeNo);
		if (udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if (this.udfParams == null) {
			this.udfParams = new AlipayHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<AlipayAcquireQueryResponse> getResponseClass() {
		return AlipayAcquireQueryResponse.class;
	}


	public boolean isNeedEncrypt() {

		return this.needEncrypt;
	}


	public void setNeedEncrypt(boolean needEncrypt) {

		this.needEncrypt = needEncrypt;
	}

	public AlipayObject getBizModel() {

		return this.bizModel;
	}


	public void setBizModel(AlipayObject bizModel) {

		this.bizModel = bizModel;
	}


}
