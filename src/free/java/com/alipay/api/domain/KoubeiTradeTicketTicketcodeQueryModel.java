package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑凭证码查询
 *
 * @author auto create
 * @since 1.0, 2018-06-15 14:43:28
 */
public class KoubeiTradeTicketTicketcodeQueryModel extends AlipayObject {

    private static final long serialVersionUID = 6575339948426587945L;

    /**
     * 口碑门店id
     */
    @ApiField("shop_id")
    private String shopId;

    /**
     * 12位的券码，券码为纯数字，且唯一不重复
     */
    @ApiField("ticket_code")
    private String ticketCode;

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTicketCode() {
        return this.ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

}
