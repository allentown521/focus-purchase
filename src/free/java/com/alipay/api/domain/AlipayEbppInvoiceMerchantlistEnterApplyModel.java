package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 商户批量入驻申请接口
 *
 * @author auto create
 * @since 1.0, 2018-01-19 10:21:21
 */
public class AlipayEbppInvoiceMerchantlistEnterApplyModel extends AlipayObject {

	private static final long serialVersionUID = 7218977285278238459L;

	/**
	 * 商户品牌信息
	 */
	@ApiField("merchant_base")
	private MerchantBaseEnterOpenModel merchantBase;

	/**
	 * 商户门店入驻产品公共信息
	 */
	@ApiField("sub_merchant_common_info")
	private SubMerchantCommonEnterOpenModel subMerchantCommonInfo;

	/**
	 * 商户门店列表信息，最多传入30个门店信息
	 */
	@ApiListField("sub_merchant_list")
	@ApiField("sub_merchant_enter_open_model")
	private List<SubMerchantEnterOpenModel> subMerchantList;

	public MerchantBaseEnterOpenModel getMerchantBase() {
		return this.merchantBase;
	}

	public void setMerchantBase(MerchantBaseEnterOpenModel merchantBase) {
		this.merchantBase = merchantBase;
	}

	public SubMerchantCommonEnterOpenModel getSubMerchantCommonInfo() {
		return this.subMerchantCommonInfo;
	}

	public void setSubMerchantCommonInfo(SubMerchantCommonEnterOpenModel subMerchantCommonInfo) {
		this.subMerchantCommonInfo = subMerchantCommonInfo;
	}

	public List<SubMerchantEnterOpenModel> getSubMerchantList() {
		return this.subMerchantList;
	}

	public void setSubMerchantList(List<SubMerchantEnterOpenModel> subMerchantList) {
		this.subMerchantList = subMerchantList;
	}

}
