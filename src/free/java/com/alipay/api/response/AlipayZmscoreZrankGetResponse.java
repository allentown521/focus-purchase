package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayZmScoreZrankResult;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.zmscore.zrank.get response.
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:27:38
 */
public class AlipayZmscoreZrankGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 8364855866853915451L;

	/**
	 * 芝麻分分段
	 */
	@ApiField("zm_score_zrank")
	private AlipayZmScoreZrankResult zmScoreZrank;

	public void setZmScoreZrank(AlipayZmScoreZrankResult zmScoreZrank) {
		this.zmScoreZrank = zmScoreZrank;
	}

	public AlipayZmScoreZrankResult getZmScoreZrank() {
		return this.zmScoreZrank;
	}

}
