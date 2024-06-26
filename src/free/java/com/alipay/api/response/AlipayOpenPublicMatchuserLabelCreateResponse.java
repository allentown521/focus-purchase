package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ErrorMatcher;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.matchuser.label.create response.
 *
 * @author auto create
 * @since 1.0, 2018-05-11 19:07:28
 */
public class AlipayOpenPublicMatchuserLabelCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 7315486117474821553L;

	/**
	 * 用户打标失败数量
	 */
	@ApiField("error_count")
	private Long errorCount;

	/**
	 * 出错的匹配器列表
	 */
	@ApiListField("error_matchers")
	@ApiField("error_matcher")
	private List<ErrorMatcher> errorMatchers;

	public void setErrorCount(Long errorCount) {
		this.errorCount = errorCount;
	}

	public Long getErrorCount() {
		return this.errorCount;
	}

	public void setErrorMatchers(List<ErrorMatcher> errorMatchers) {
		this.errorMatchers = errorMatchers;
	}

	public List<ErrorMatcher> getErrorMatchers() {
		return this.errorMatchers;
	}

}
