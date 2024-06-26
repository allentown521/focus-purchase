package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExtItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: koubei.item.extitem.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2016-07-06 10:48:09
 */
public class KoubeiItemExtitemBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6856262218787241676L;

	/**
	 * 商品信息列表
	 */
	@ApiListField("model_list")
	@ApiField("ext_item")
	private List<ExtItem> modelList;

	/**
	 * 当前页码
	 */
	@ApiField("page_num")
	private String pageNum;

	/**
	 * 分页大小
	 */
	@ApiField("page_size")
	private String pageSize;

	/**
	 * 总记录数
	 */
	@ApiField("total_size")
	private String totalSize;

	public void setModelList(List<ExtItem> modelList) {
		this.modelList = modelList;
	}

	public List<ExtItem> getModelList() {
		return this.modelList;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageNum() {
		return this.pageNum;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageSize() {
		return this.pageSize;
	}

	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}

	public String getTotalSize() {
		return this.totalSize;
	}

}
