package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CplifeRoomDetail;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.eco.cplife.roominfo.query response.
 *
 * @author auto create
 * @since 1.0, 2018-06-09 20:17:57
 */
public class AlipayEcoCplifeRoominfoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8194978884166542644L;

	/**
	 * 符合条件的小区房屋信息列表.
	 */
	@ApiListField("room_info")
	@ApiField("cplife_room_detail")
	private List<CplifeRoomDetail> roomInfo;

	/**
	 * 该小区下已上传的房间总数
	 */
	@ApiField("total_room_number")
	private Long totalRoomNumber;

	public void setRoomInfo(List<CplifeRoomDetail> roomInfo) {
		this.roomInfo = roomInfo;
	}

	public List<CplifeRoomDetail> getRoomInfo() {
		return this.roomInfo;
	}

	public void setTotalRoomNumber(Long totalRoomNumber) {
		this.totalRoomNumber = totalRoomNumber;
	}

	public Long getTotalRoomNumber() {
		return this.totalRoomNumber;
	}

}
