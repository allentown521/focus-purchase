package allen.town.focus_purchase.ui

import allen.town.core.service.AliPayService
import allen.town.core.service.GooglePayService
import allen.town.core.service.PayService
import allen.town.focus_purchase.alipay.AliPayEntry
import allen.town.focus_purchase.alipay.AliPayServiceWrap.tradeWithHBService
import allen.town.focus_common.util.EntityDateUtils
import allen.town.focus_common.util.PackageUtils
import allen.town.focus_common.util.Timber
import allen.town.focus_common.views.AccentMaterialDialog
import allen.town.focus_purchase.MyBaseApp
import allen.town.focus_purchase.R
import allen.town.focus_purchase.data.db.table.GooglePlayInAppTable
import allen.town.focus_purchase.iap.SupporterException
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import com.alipay.api.AlipayResponse
import com.alipay.api.internal.util.ZxingUtils
import com.alipay.api.response.AlipayTradeQueryResponse
import com.alipay.demo.trade.model.ExtendParams
import com.alipay.demo.trade.model.GoodsDetail
import com.alipay.demo.trade.model.TradeStatus
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder
import com.alipay.demo.trade.utils.Utils
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*
import com.wyjson.router.GoRouter

class AliPayFragment(val aliPayEntry: AliPayEntry, val subscriber: Subscriber<in Boolean>) :
    AppCompatDialogFragment() {

    var qrIv: ImageView? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val rootView =
            LayoutInflater.from(activity).inflate(R.layout.activity_alipay, null as ViewGroup?)
        qrIv = rootView.findViewById(R.id.qr)
        tradePrecreate(aliPayEntry)
        val dialog =
            AccentMaterialDialog(
                requireContext(),
                allen.town.focus_common.R.style.MaterialAlertDialogTheme
            ).setTitle(allen.town.focus_common.R.string.purchase).setView(rootView)
                .create()
        dialog.setCanceledOnTouchOutside(false)
        //没有这行reader显示底部textview提示不全
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return dialog
    }


    fun showIt(fragmentManager: FragmentManager) {
        show(fragmentManager, "")
    }

    // 简单打印应答
    private fun dumpResponse(response: AlipayResponse?) {
        if (response != null) {
            Timber.i(String.format("code:%s, msg:%s", response.code, response.msg))
            if (!TextUtils.isEmpty(response.subCode)) {
                Timber.i(
                    String.format(
                        "subCode:%s, subMsg:%s", response.subCode,
                        response.subMsg
                    )
                )
            }
            Timber.i("body:" + response.body)
        }
    }

    // 测试当面付2.0生成支付二维码
    fun tradePrecreate(aliPayEntry: AliPayEntry) {
        // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
        // 需保证商户系统端不能重复，建议通过数据库sequence生成，
        val outTradeNo = (PackageUtils.getAppName(context) + System.currentTimeMillis()
                + (Math.random() * 10000000L).toLong())


        // (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
        val subject = aliPayEntry.subject


        // (必填) 订单总金额，单位为元，不能超过1亿元
        // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
        val totalAmount = aliPayEntry.totalAmount


        // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
        // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
        val undiscountableAmount = "0"


        // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
        // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
        val sellerId = ""

        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
        val body = aliPayEntry.body

        // 商户操作员编号，添加此参数可以为商户操作员做销售统计

        val operatorId = "test_operator_id"


        // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
//        val storeId = "test_store_id"
        val storeId = "FocusReader-alipay"


        // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
        val extendParams = ExtendParams()
        extendParams.sysServiceProviderId = "2088100200300400500"


        // 支付超时，定义为120分钟
        val timeoutExpress = "120m"


        // 商品明细列表，需填写购买商品详细信息，
        val goodsDetailList: MutableList<GoodsDetail> = ArrayList()
        // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
        val goods1 = GoodsDetail.newInstance(
            aliPayEntry.subId, aliPayEntry.subject, 10
                ?: 0, 1
        )
        // 创建好一个商品后添加至商品明细列表
        goodsDetailList.add(goods1)

        // 创建扫码支付请求builder，设置请求参数
        val builder = AlipayTradePrecreateRequestBuilder()
            .setSubject(subject).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo)
            .setUndiscountableAmount(undiscountableAmount).setSellerId(sellerId).setBody(body)
            .setOperatorId(operatorId).setStoreId(storeId).setExtendParams(extendParams)
            .setTimeoutExpress(timeoutExpress) //                .setNotifyUrl("http://www.test-notify-url.com")//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
            .setGoodsDetailList(goodsDetailList)


        Observable.just(0).subscribeOn(Schedulers.io())
            .map { integer: Int? -> tradeWithHBService?.tradePrecreate(builder) }
            .observeOn(AndroidSchedulers.mainThread()).subscribe { result ->
                when (result?.tradeStatus) {
                    TradeStatus.SUCCESS -> {
                        Timber.i("支付宝预下单成功: )")
                        val response = result.response
                        dumpResponse(response)
                        try {
                            // 调用方法createCode生成二维码
                            val logo = getAppIcon(context)
                            val bm = ZxingUtils.createCode(context, response.getQrCode(), logo)
                            // 将二维码在界面中显示
                            qrIv?.setImageBitmap(bm)


                            Observable.just(0).observeOn(Schedulers.io()).subscribe {

                                // 返回用户处理中，则轮询查询交易是否成功，如果查询超时，则调用撤销
                                val response: AlipayTradeQueryResponse? =
                                    tradeWithHBService?.loopQueryResult(
                                        AlipayTradeQueryRequestBuilder()
                                            .setOutTradeNo(outTradeNo)
                                    )
                                when (tradeWithHBService?.checkF2FQueryAndCancel(
                                    outTradeNo,
                                    response
                                )) {
                                    TradeStatus.SUCCESS -> {
                                        Timber.i("查询返回该订单支付成功: )")
                                        dumpResponse(response)
                                        Timber.i(response?.tradeStatus)
                                        if (Utils.isListNotEmpty(response?.fundBillList)) {
                                            response?.fundBillList?.run {
                                                for (bill in this) {
                                                    Timber.i(bill.fundChannel + ":" + bill.amount)
                                                }
                                            }

                                        }

                                        var expiredTime = 0L
                                        if (aliPayEntry.subId == GoRouter.getInstance().getService(
                                                GooglePayService::class.java)!!.getQuarterlyId()) {
                                            expiredTime = EntityDateUtils.addDays(Date(), 90)
                                        } else if (aliPayEntry.subId == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getYearlyId()) {
                                            expiredTime = EntityDateUtils.addDays(Date(), 365)
                                        }  else if (aliPayEntry.subId == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getMonthId()) {
                                            expiredTime = EntityDateUtils.addDays(Date(), 30)
                                        } else if (aliPayEntry.subId == GoRouter.getInstance().getService(GooglePayService::class.java)!!.getWeeklyId()
                                        ) {
                                            expiredTime = EntityDateUtils.addDays(Date(), 7)
                                        }

                                        if (GoRouter.getInstance().getService(AliPayService::class.java)!!.getRemoveAdPrice().toFloat() == totalAmount?.toFloat()) {
                                            Timber.i("is alipay remove ad")
                                            GoRouter.getInstance().getService(PayService::class.java)!!.setRemoveAdPurchase(true)
                                            MyBaseApp.getDb(requireContext()).googlePlayInAppPurchase
                                                .update(GooglePlayInAppTable.TYPE_REMOVE_ADS, response?.tradeNo)
                                            //这里用dismiss偶尔会抛异常,Can not perform this action after onSaveInstanceState，但是捕获异常也没问题，因为后续逻辑走完了,用dismissAllowingStateLoss正常
                                            activity?.runOnUiThread { dismissAllowingStateLoss() }
                                            subscriber.onNext(true)
                                            subscriber.onCompleted()
                                            return@subscribe
                                        }

                                        //支付成功修改状态
                                        GoRouter.getInstance().getService(PayService::class.java)!!.setPurchase(true)
                                        //这里存数据库时用支付宝订单id而不是商户订单号,因为支付宝订单号复制更方便
                                        MyBaseApp.getDb(requireContext()).alipayPurchase()
                                            .update(expiredTime, response?.tradeNo)
                                        //这里用dismiss偶尔会抛异常,Can not perform this action after onSaveInstanceState，但是捕获异常也没问题，因为后续逻辑走完了,用dismissAllowingStateLoss正常
                                        activity?.runOnUiThread { dismissAllowingStateLoss() }
                                        subscriber.onNext(true)
                                        subscriber.onCompleted()
                                    }
                                    TradeStatus.FAILED -> {
                                        activity?.runOnUiThread { dismissAllowingStateLoss() }
                                        Timber.e("查询返回该订单支付失败或被关闭!!!")
                                        subscriber.onError(SupporterException("查询返回该订单支付失败或被关闭!!!"))
                                    }
                                    TradeStatus.UNKNOWN -> {
                                        activity?.runOnUiThread { dismissAllowingStateLoss() }
                                        Timber.e("系统异常，预下单状态未知!!!")
                                        subscriber.onError(SupporterException("系统异常，预下单状态未知!!!"))
                                    }
                                    else -> {
                                        activity?.runOnUiThread { dismissAllowingStateLoss() }
                                        Timber.e("不支持的交易状态，交易返回异常!!!")
                                        subscriber.onError(SupporterException("不支持的交易状态，交易返回异常!!!"))
                                    }
                                }
                            }

                        } catch (e: Exception) {
                            Timber.e(e,"show qr failed")
                            subscriber.onError(SupporterException("show qr failed"))
                        }
                    }
                    TradeStatus.FAILED -> {
                        Timber.e("支付宝预下单失败!!!")
                        subscriber.onError(SupporterException("支付宝预下单失败!!!"))
                    }
                    TradeStatus.UNKNOWN -> {
                        Timber.e("系统异常，预下单状态未知!!!")
                        subscriber.onError(SupporterException("系统异常，预下单状态未知!!!"))
                    }
                    else -> {
                        Timber.e("不支持的交易状态，交易返回异常!!!")
                        subscriber.onError(SupporterException("不支持的交易状态，交易返回异常!!!"))
                    }
                }
            }
    }

    fun getAppIcon(context: Context?): Bitmap? {
        if (context == null) {
            return null
        }
        try {
            val packageManager: PackageManager = context.packageManager
            val packageName: String = context.packageName
            //三星s22获取的不对？包名获取错误，似乎不能用application context）
            Timber.i("get packageName $packageName")
            val drawable: Drawable = packageManager.getApplicationIcon(packageName)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (drawable is BitmapDrawable) {
                    return drawable.bitmap
                } else {
                    //if (drawable is AdaptiveIconDrawable)
                    val bitmap = Bitmap.createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        Bitmap.Config.ARGB_8888
                    );
                    val canvas = Canvas(bitmap)
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
                    drawable.draw(canvas)
                    return bitmap
                }
            } else {
                return (drawable as BitmapDrawable).bitmap
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}