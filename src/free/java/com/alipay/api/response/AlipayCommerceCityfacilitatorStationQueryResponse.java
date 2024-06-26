package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.StationDetailInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.commerce.cityfacilitator.station.query response.
 *
 * @author auto create
 * @since 1.0, 2016-08-03 16:10:49
 */
public class AlipayCommerceCityfacilitatorStationQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5615659162158216227L;

	/**
	 * 支持设为起点的站点列表
	 */
	@ApiListField("support_starts")
	@ApiField("station_detail_info")
	private List<StationDetailInfo> supportStarts;

	public void setSupportStarts(List<StationDetailInfo> supportStarts) {
		this.supportStarts = supportStarts;
	}

	public List<StationDetailInfo> getSupportStarts() {
		return this.supportStarts;
	}

}
