package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 部署单处理反馈参数
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:50:53
 */
public class AlipayDataDataserviceDeployorderResultSendModel extends AlipayObject {

    private static final long serialVersionUID = 5572777983551155887L;

    /**
     * 部署单记录id
     */
    @ApiField("record_id")
    private String recordId;

    /**
     * 处理结果
     */
    @ApiField("result")
    private String result;

    /**
     * 是否成功
     */
    @ApiField("success")
    private Boolean success;

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
