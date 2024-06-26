package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SingleArticleAnalysisData;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.singlearticle.data.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 15:06:32
 */
public class AlipayOpenPublicSinglearticleDataBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1423429565117976262L;

	/**
	 * 单篇文章分析数据列表
	 */
	@ApiListField("data_list")
	@ApiField("single_article_analysis_data")
	private List<SingleArticleAnalysisData> dataList;

	public void setDataList(List<SingleArticleAnalysisData> dataList) {
		this.dataList = dataList;
	}

	public List<SingleArticleAnalysisData> getDataList() {
		return this.dataList;
	}

}
