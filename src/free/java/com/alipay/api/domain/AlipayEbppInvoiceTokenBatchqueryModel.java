package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 根据查询令牌获取发票要素列表
 *
 * @author auto create
 * @since 1.0, 2018-04-23 13:16:26
 */
public class AlipayEbppInvoiceTokenBatchqueryModel extends AlipayObject {

    private static final long serialVersionUID = 3563497357278696889L;

    /**
     * 查询请求令牌
     * 通过唤起支付宝钱包后用户进入发票管家选择发票列表后创建，并通过isv接收url回传给isv
     */
    @ApiField("invoice_token")
    private String invoiceToken;

    /**
     * 发票要素获取应用场景
     * 固定值
     * INVOICE_EXPENSE
     */
    @ApiField("scene")
    private String scene;

    public String getInvoiceToken() {
        return this.invoiceToken;
    }

    public void setInvoiceToken(String invoiceToken) {
        this.invoiceToken = invoiceToken;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

}
