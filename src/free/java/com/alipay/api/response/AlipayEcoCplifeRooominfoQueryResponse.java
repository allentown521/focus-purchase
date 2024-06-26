package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CplifeRoomDetail;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.eco.cplife.rooominfo.query response.
 *
 * @author auto create
 * @since 1.0, 2017-02-10 18:51:44
 */
public class AlipayEcoCplifeRooominfoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5122474234785148761L;

	/**
	 * 符合条件的小区房屋信息列表.
	 */
	@ApiListField("room_info")
	@ApiField("cplife_room_detail")
	private List<CplifeRoomDetail> roomInfo;

	public void setRoomInfo(List<CplifeRoomDetail> roomInfo) {
		this.roomInfo = roomInfo;
	}

	public List<CplifeRoomDetail> getRoomInfo() {
		return this.roomInfo;
	}

}
