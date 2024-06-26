package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.tags.query response.
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:34:54
 */
public class KoubeiMarketingCampaignTagsQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2151155281333355378L;

	/**
	 * 查询成功时返回人群标签信息查询失败时为空
	 * code:表示标签code
	 * name:表示标签名称
	 * valueRange：表示标签的取值范围
	 * value:表示标签具体取值
	 * label:描述信息
	 * 标签相关的详细信息参见附件。<a href="http://aopsdkdownload.cn-hangzhou.alipay-pub.aliyun-inc.com/doc/tags%26usecase.zip">标签信息</a>
	 */
	@ApiField("tags")
	private String tags;

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return this.tags;
	}

}
