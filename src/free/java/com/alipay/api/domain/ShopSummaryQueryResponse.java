package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * 门店查询摘要信息接口模型
 *
 * @author auto create
 * @since 1.0, 2017-02-17 14:20:04
 */
public class ShopSummaryQueryResponse extends AlipayObject {

	private static final long serialVersionUID = 8666299551457176294L;

	/**
	 * 门店地址
	 */
	@ApiField("address")
	private String address;

	/**
	 * 分店名
	 */
	@ApiField("branch_shop_name")
	private String branchShopName;

	/**
	 * 品牌名，不填写则默认为其它品牌
	 */
	@ApiField("brand_name")
	private String brandName;

	/**
	 * 经营时间
	 */
	@ApiField("business_time")
	private String businessTime;

	/**
	 * 门店类目列表
	 */
	@ApiListField("category_infos")
	@ApiField("shop_category_info")
	private List<ShopCategoryInfo> categoryInfos;

	/**
	 * 城市编码，国标码，详见国家统计局数据 <a href="http://aopsdkdownload.cn-hangzhou.alipay-pub.aliyun-inc.com/doc/AreaCodeList.zip">点此下载</a>
	 */
	@ApiField("city_code")
	private String cityCode;

	/**
	 * 区县编码，国标码，详见国家统计局数据 <a href="http://aopsdkdownload.cn-hangzhou.alipay-pub.aliyun-inc.com/doc/AreaCodeList.zip">点此下载</a>
	 */
	@ApiField("district_code")
	private String districtCode;

	/**
	 * 创建时间
	 */
	@ApiField("gmt_create")
	private String gmtCreate;

	/**
	 * 门店是否在客户端显示，T表示显示，F表示隐藏
	 */
	@ApiField("is_show")
	private String isShow;

	/**
	 * 纬度，只有在query_type=KB_PROMOTER非空
	 */
	@ApiField("latitude")
	private String latitude;

	/**
	 * 经度，只有在query_type=KB_PROMOTER非空
	 */
	@ApiField("longitude")
	private String longitude;

	/**
	 * 门店首图
	 */
	@ApiField("main_image")
	private String mainImage;

	/**
	 * 主门店名
	 */
	@ApiField("main_shop_name")
	private String mainShopName;

	/**
	 * 图片集，是map转化成的json串，key是图片id,value是图片url
	 */
	@ApiField("pic_coll")
	private String picColl;

	/**
	 * 省份编码，国标码，详见国家统计局数据 <a href="http://aopsdkdownload.cn-hangzhou.alipay-pub.aliyun-inc.com/doc/AreaCodeList.zip">点此下载</a>
	 */
	@ApiField("province_code")
	private String provinceCode;

	/**
	 * 门店评论信息
	 */
	@ApiField("shop_comment_info")
	private ShopCommentInfo shopCommentInfo;

	/**
	 * 门店ID
	 */
	@ApiField("shop_id")
	private String shopId;

	/**
	 * COMMON（普通门店）、MALL（商圈）
	 */
	@ApiField("shop_type")
	private String shopType;

	/**
	 * 门店状态，OPEN：营业中、PAUSE：暂停营业、FREEZE：已冻结、CLOSE:门店已关闭
	 */
	@ApiField("status")
	private String status;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranchShopName() {
		return this.branchShopName;
	}

	public void setBranchShopName(String branchShopName) {
		this.branchShopName = branchShopName;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBusinessTime() {
		return this.businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public List<ShopCategoryInfo> getCategoryInfos() {
		return this.categoryInfos;
	}

	public void setCategoryInfos(List<ShopCategoryInfo> categoryInfos) {
		this.categoryInfos = categoryInfos;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMainImage() {
		return this.mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getMainShopName() {
		return this.mainShopName;
	}

	public void setMainShopName(String mainShopName) {
		this.mainShopName = mainShopName;
	}

	public String getPicColl() {
		return this.picColl;
	}

	public void setPicColl(String picColl) {
		this.picColl = picColl;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public ShopCommentInfo getShopCommentInfo() {
		return this.shopCommentInfo;
	}

	public void setShopCommentInfo(ShopCommentInfo shopCommentInfo) {
		this.shopCommentInfo = shopCommentInfo;
	}

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopType() {
		return this.shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
