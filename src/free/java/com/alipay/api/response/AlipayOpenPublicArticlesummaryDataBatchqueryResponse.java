package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ArticleSummaryAnalysisData;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.articlesummary.data.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-01-05 15:08:10
 */
public class AlipayOpenPublicArticlesummaryDataBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3129134243533691188L;

	/**
	 * 文章分析数据列表
	 */
	@ApiListField("data_list")
	@ApiField("article_summary_analysis_data")
	private List<ArticleSummaryAnalysisData> dataList;

	public void setDataList(List<ArticleSummaryAnalysisData> dataList) {
		this.dataList = dataList;
	}

	public List<ArticleSummaryAnalysisData> getDataList() {
		return this.dataList;
	}

}
