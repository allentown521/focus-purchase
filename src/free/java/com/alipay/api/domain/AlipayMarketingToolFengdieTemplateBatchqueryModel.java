package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 获取云凤蝶空间可用模板列表
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:14:34
 */
public class AlipayMarketingToolFengdieTemplateBatchqueryModel extends AlipayObject {

    private static final long serialVersionUID = 4673449623479449126L;

    /**
     * 作为当前操作者的空间成员用户名， 值为 origin_user_id
     */
    @ApiField("operator")
    private String operator;

    /**
     * 当前页数，默认为1
     */
    @ApiField("page_number")
    private String pageNumber;

    /**
     * 每页记录数，不能超过50，默认为10
     */
    @ApiField("page_size")
    private String pageSize;

    /**
     * 欲查询的空间 ID
     */
    @ApiField("space_id")
    private String spaceId;

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

}
