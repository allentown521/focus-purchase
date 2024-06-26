package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 小程序下架
 *
 * @author auto create
 * @since 1.0, 2017-12-20 11:16:58
 */
public class AlipayOpenMiniVersionOfflineModel extends AlipayObject {

    private static final long serialVersionUID = 8278155937763328758L;

    /**
     * 小程序版本号
     */
    @ApiField("app_version")
    private String appVersion;

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
