package allen.town.focus_purchase.alipay

import allen.town.core.service.AliPayService
import com.alipay.demo.trade.config.Configs
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl
import com.wyjson.router.GoRouter

object AliPayServiceWrap {
    // 支付宝当面付2.0服务（集成了交易保障接口逻辑）
    var tradeWithHBService: AlipayTradeWithHBServiceImpl? = null

    init {
        Configs.setPid(GoRouter.getInstance().getService(AliPayService::class.java)!!.getPid())
        //--------------------沙箱配置-------------------------------------
        //沙箱appid
//        Configs.setAppid("2016110200787382")
        //沙箱domain
//        Configs.setOpenApiDomain("https://openapi.alipaydev.com/gateway.do")
        //沙箱应用私钥
//        Configs.setPrivateKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getSandboxPrivateKey())
//        沙箱应用公钥
//        Configs.setPublicKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getSandboxPublicKey())
        //沙箱支付宝公钥
//        Configs.setAlipayPublicKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getSandboxAlipayPublicKey())

        //--------------------生产配置---------------------------------
        //生产appid
        Configs.setAppid(GoRouter.getInstance().getService(AliPayService::class.java)!!.getAppId())
        //生产domain
        Configs.setOpenApiDomain("https://openapi.alipay.com/gateway.do")
        //生产应用私钥
        Configs.setPrivateKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getPrivateKey())
        //生产应用公钥
        Configs.setPublicKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getPublicKey())
        //生产支付宝公钥
        Configs.setAlipayPublicKey(GoRouter.getInstance().getService(AliPayService::class.java)!!.getAlipayPublicKey())
        //-----------------------------------------------------------

        //签名类型: RSA->SHA1withRsa,RSA2->SHA256withRsa
        Configs.setSignType("RSA2")
        //当面付最大查询次数和查询间隔（毫秒），算下来是30分钟
        Configs.setMaxQueryRetry(900)
        Configs.setQueryDuration(2000)
        //当面付最大撤销次数和撤销间隔（毫秒）
        Configs.setMaxCancelRetry(3)
        Configs.setCancelDuration(2000)
        //交易保障线程第一次调度延迟和调度间隔（秒）
        Configs.setHeartbeatDelay(5)
        Configs.setHeartbeatDuration(900)
        /** 使用Configs提供的默认参数
         *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
         */

        // 支付宝当面付2.0服务（集成了交易保障接口逻辑）
        tradeWithHBService = AlipayTradeWithHBServiceImpl.ClientBuilder().build()

    }
}