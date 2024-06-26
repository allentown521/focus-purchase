package com.alipay.api.request;

import com.alipay.api.AlipayObject;
import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.domain.RegionInfo;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOpenMiniVersionAuditApplyResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ALIPAY API: alipay.open.mini.version.audit.apply request
 *
 * @author auto create
 * @since 1.0, 2018-06-04 19:40:00
 */
public class AlipayOpenMiniVersionAuditApplyRequest implements AlipayUploadRequest<AlipayOpenMiniVersionAuditApplyResponse> {

	private AlipayHashMap udfParams; // add user-defined text parameters
	private String apiVersion = "1.0";

	/**
	 * 小程序类目，格式为 第一个一级类目_第一个二级类目;第二个一级类目_第二个二级类目，详细类目可以参考https://docs.alipay.com/isv/10325，如果不填默认采用当前小程序应用类目
	 */
	private String appCategoryIds;

	/**
	 * 小程序应用描述，20-200个字，如果不填默认采用当前小程序的应用描述
	 */
	private String appDesc;

	/**
	 * 小程序应用英文名称，如果不填默认采用当前小程序应用英文名称
	 */
	private String appEnglishName;

	/**
	 * 小程序logo图标，图片格式必须为：png、jpeg、jpg，建议上传像素为180*180，如果不填默认采用当前小程序应用logo图标
	 */
	private FileItem appLogo;

	/**
	 * 小程序应用名称，如果不填默认采用当前小程序应用名称
	 */
	private String appName;

	/**
	 * 小程序应用简介，一句话描述小程序功能，如果不填默认采用当前小程序应用简介
	 */
	private String appSlogan;

	/**
	 * 小程序版本号
	 */
	private String appVersion;

	/**
	 * 第五张营业执照照片，不能超过4MB，图片格式只支持jpg，png，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem fifthLicensePic;

	/**
	 * 小程序第五张应用截图，不能超过4MB，图片格式只支持jpg，png
	 */
	private FileItem fifthScreenShot;

	/**
	 * 第一张营业执照照片，不能超过4MB，图片格式只支持jpg，png，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem firstLicensePic;

	/**
	 * 实例化的小程序可以不用传第一张应用截图，小程序第一张应用截图，不能超过4MB，图片格式只支持jpg，png
	 */
	private FileItem firstScreenShot;

	/**
	 * 第四张营业执照照片，不能超过4MB，图片格式只支持jpg，png，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem fourthLicensePic;

	/**
	 * 小程序第四张应用截图，不能超过4MB，图片格式只支持jpg，png
	 */
	private FileItem fourthScreenShot;

	/**
	 * 营业执照名称，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private String licenseName;

	/**
	 * 营业执照号，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private String licenseNo;

	/**
	 * 营业执照有效期，格式为yyyy-MM-dd，9999-12-31表示长期，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private String licenseValidDate;

	/**
	 * 小程序备注
	 */
	private String memo;

	/**
	 * 门头照图片，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem outDoorPic;

	/**
	 * 小程序服务区域类型，GLOBAL-全球，CHINA-中国，LOCATION-指定区域
	 */
	private String regionType;

	/**
	 * 第二张营业执照照片，不能超过4MB，图片格式只支持jpg，png，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem secondLicensePic;

	/**
	 * 实例化的小程序可以不用传第二张应用截图，小程序第二张应用截图，不能超过4MB，图片格式只支持jpg，png
	 */
	private FileItem secondScreenShot;

	/**
	 * 小程序客服邮箱，如果不填默认采用当前小程序的应用客服邮箱
	 */
	private String serviceEmail;

	/**
	 * 小程序客服电话，如果不填默认采用当前小程序的应用客服电话
	 */
	private String servicePhone;

	/**
	 * 省市区信息，当区域类型为LOCATION时，不能为空，province_code不能为空，当填写city_code时，province_code不能为空，当填写area_code时，province_code和city_code不能为空。只填province_code时，该省全部选择；province_code和city_code都填时，该市全部选择。province_code，city_code和area_code都填时，该县全部选择。具体code可以参考https://docs.alipay.com/isv/10327
	 */
	private List<RegionInfo> serviceRegionInfo;

	/**
	 * 第三张营业执照照片，不能超过4MB，图片格式只支持jpg，png，部分小程序类目需要提交，参照https://docs.alipay.com/isv/10325中是否需要营业执照信息
	 */
	private FileItem thirdLicensePic;

	/**
	 * 小程序第三张应用截图，不能超过4MB，图片格式只支持jpg，png
	 */
	private FileItem thirdScreenShot;

	/**
	 * 小程序版本描述
	 */
	private String versionDesc;

	public void setAppCategoryIds(String appCategoryIds) {
		this.appCategoryIds = appCategoryIds;
	}

	public String getAppCategoryIds() {
		return this.appCategoryIds;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppDesc() {
		return this.appDesc;
	}

	public void setAppEnglishName(String appEnglishName) {
		this.appEnglishName = appEnglishName;
	}

	public String getAppEnglishName() {
		return this.appEnglishName;
	}

	public void setAppLogo(FileItem appLogo) {
		this.appLogo = appLogo;
	}

	public FileItem getAppLogo() {
		return this.appLogo;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppSlogan(String appSlogan) {
		this.appSlogan = appSlogan;
	}

	public String getAppSlogan() {
		return this.appSlogan;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setFifthLicensePic(FileItem fifthLicensePic) {
		this.fifthLicensePic = fifthLicensePic;
	}

	public FileItem getFifthLicensePic() {
		return this.fifthLicensePic;
	}

	public void setFifthScreenShot(FileItem fifthScreenShot) {
		this.fifthScreenShot = fifthScreenShot;
	}

	public FileItem getFifthScreenShot() {
		return this.fifthScreenShot;
	}

	public void setFirstLicensePic(FileItem firstLicensePic) {
		this.firstLicensePic = firstLicensePic;
	}

	public FileItem getFirstLicensePic() {
		return this.firstLicensePic;
	}

	public void setFirstScreenShot(FileItem firstScreenShot) {
		this.firstScreenShot = firstScreenShot;
	}

	public FileItem getFirstScreenShot() {
		return this.firstScreenShot;
	}

	public void setFourthLicensePic(FileItem fourthLicensePic) {
		this.fourthLicensePic = fourthLicensePic;
	}

	public FileItem getFourthLicensePic() {
		return this.fourthLicensePic;
	}

	public void setFourthScreenShot(FileItem fourthScreenShot) {
		this.fourthScreenShot = fourthScreenShot;
	}

	public FileItem getFourthScreenShot() {
		return this.fourthScreenShot;
	}

	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}

	public String getLicenseName() {
		return this.licenseName;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseNo() {
		return this.licenseNo;
	}

	public void setLicenseValidDate(String licenseValidDate) {
		this.licenseValidDate = licenseValidDate;
	}

	public String getLicenseValidDate() {
		return this.licenseValidDate;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setOutDoorPic(FileItem outDoorPic) {
		this.outDoorPic = outDoorPic;
	}

	public FileItem getOutDoorPic() {
		return this.outDoorPic;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public String getRegionType() {
		return this.regionType;
	}

	public void setSecondLicensePic(FileItem secondLicensePic) {
		this.secondLicensePic = secondLicensePic;
	}

	public FileItem getSecondLicensePic() {
		return this.secondLicensePic;
	}

	public void setSecondScreenShot(FileItem secondScreenShot) {
		this.secondScreenShot = secondScreenShot;
	}

	public FileItem getSecondScreenShot() {
		return this.secondScreenShot;
	}

	public void setServiceEmail(String serviceEmail) {
		this.serviceEmail = serviceEmail;
	}

	public String getServiceEmail() {
		return this.serviceEmail;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public String getServicePhone() {
		return this.servicePhone;
	}

	public void setServiceRegionInfo(List<RegionInfo> serviceRegionInfo) {
		this.serviceRegionInfo = serviceRegionInfo;
	}

	public List<RegionInfo> getServiceRegionInfo() {
		return this.serviceRegionInfo;
	}

	public void setThirdLicensePic(FileItem thirdLicensePic) {
		this.thirdLicensePic = thirdLicensePic;
	}

	public FileItem getThirdLicensePic() {
		return this.thirdLicensePic;
	}

	public void setThirdScreenShot(FileItem thirdScreenShot) {
		this.thirdScreenShot = thirdScreenShot;
	}

	public FileItem getThirdScreenShot() {
		return this.thirdScreenShot;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	public String getVersionDesc() {
		return this.versionDesc;
	}

	private String terminalType;
	private String terminalInfo;
	private String prodCode;
	private String notifyUrl;
	private String returnUrl;
	private boolean needEncrypt = false;
	private AlipayObject bizModel = null;

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalType() {
		return this.terminalType;
	}

	public void setTerminalInfo(String terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public String getTerminalInfo() {
		return this.terminalInfo;
	}

	public String getProdCode() {
		return this.prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getApiMethodName() {
		return "alipay.open.mini.version.audit.apply";
	}

	public Map<String, String> getTextParams() {
		AlipayHashMap txtParams = new AlipayHashMap();
		txtParams.put("app_category_ids", this.appCategoryIds);
		txtParams.put("app_desc", this.appDesc);
		txtParams.put("app_english_name", this.appEnglishName);
		txtParams.put("app_name", this.appName);
		txtParams.put("app_slogan", this.appSlogan);
		txtParams.put("app_version", this.appVersion);
		txtParams.put("license_name", this.licenseName);
		txtParams.put("license_no", this.licenseNo);
		txtParams.put("license_valid_date", this.licenseValidDate);
		txtParams.put("memo", this.memo);
		txtParams.put("region_type", this.regionType);
		txtParams.put("service_email", this.serviceEmail);
		txtParams.put("service_phone", this.servicePhone);
		txtParams.put("service_region_info", this.serviceRegionInfo == null ? null : new com.alipay.api.internal.util.json.JSONWriter().write(this.serviceRegionInfo, true));
		txtParams.put("version_desc", this.versionDesc);
		if (udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if (this.udfParams == null) {
			this.udfParams = new AlipayHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("app_logo", this.appLogo);
		params.put("fifth_license_pic", this.fifthLicensePic);
		params.put("fifth_screen_shot", this.fifthScreenShot);
		params.put("first_license_pic", this.firstLicensePic);
		params.put("first_screen_shot", this.firstScreenShot);
		params.put("fourth_license_pic", this.fourthLicensePic);
		params.put("fourth_screen_shot", this.fourthScreenShot);
		params.put("out_door_pic", this.outDoorPic);
		params.put("second_license_pic", this.secondLicensePic);
		params.put("second_screen_shot", this.secondScreenShot);
		params.put("third_license_pic", this.thirdLicensePic);
		params.put("third_screen_shot", this.thirdScreenShot);
		return params;
	}

	public Class<AlipayOpenMiniVersionAuditApplyResponse> getResponseClass() {
		return AlipayOpenMiniVersionAuditApplyResponse.class;
	}

	public boolean isNeedEncrypt() {

		return this.needEncrypt;
	}


	public void setNeedEncrypt(boolean needEncrypt) {

		this.needEncrypt = needEncrypt;
	}

	public AlipayObject getBizModel() {

		return this.bizModel;
	}


	public void setBizModel(AlipayObject bizModel) {

		this.bizModel = bizModel;
	}


}
