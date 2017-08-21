package com.xyz.company;

import com.google.common.base.Joiner;
import com.xyz.company.util.MD5Util;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Xiao on 2017/8/21.
 */
public class CcbPayUrl {

    public static void main(String[] args){
        Map<String, String> paramMap = new LinkedHashMap<String, String>();
        // 商户代码:TODO:找话机世界拿
        paramMap.put("MERCHANTID", "105331000001676");
        // 商户柜台代码 TODO:找话机世界拿
        paramMap.put("POSID", "002130298");
        // 分行代码 TODO:找话机世界拿
        paramMap.put("BRANCHID", "330000000");
        // 订单号
        paramMap.put("ORDERID", "19991101234");
        // 付款金额
        paramMap.put("PAYMENT", "0.01");
        // 币种,人民币
        paramMap.put("CURCODE", "01");
        // 交易码 由建行统一分配为520100
        paramMap.put("TXCODE", "520100");
        // 备注
        String orderUid = "102093_239893_22314";
        paramMap.put("REMARK1", orderUid);
        paramMap.put("REMARK2", "");
        // 接口类型 1-防钓鱼接口
        paramMap.put("TYPE", "1");
        // 公钥后30位,作为源串参加MD5摘要 TODO:找话机世界拿
        paramMap.put("PUB", "5d6768a74aa9db27b86b8e9b020111");
        // 网关类型
        paramMap.put("GATEWAY", "");
        // 客户在商户系统的ip
        paramMap.put("CLIENTIP", "128.128.80.125"); // TODO:ip确认
        // 客户注册信息 StringEscapeUtils.escapeJava("小飞侠");
        paramMap.put("REGINFO", StringEscapeUtils.escapeJava( "xiaofeixia"));
        // 商品信息 StringEscapeUtils.escapeJava("小飞侠");
        paramMap.put("PROINFO", StringEscapeUtils.escapeJava("digital"));
        //
        paramMap.put("REFERER", "");
        // 客户端标识:TODO:配置写入
//        paramMap.put("THIRDAPPINFO", "comccbpay105331000001676huajishijie");
        // 订单超时时间
//        paramMap.put("TIMEOUT", "");

        String macStr = Joiner.on("&").withKeyValueSeparator("=").join(paramMap);
        // 去掉&TIMEOUT=,没有值不进行MAC校验
//        String macStr = paramStr.substring(0, paramStr.length() - 9);
        // MAC校验
        String mac = MD5Util.MD5Encode(macStr, "UTF-8");

        paramMap.put("MAC", mac);
        paramMap.remove("PUB");
        // 拼成完整的url返回给app端
        String urlPrefix = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain?";
        String allParamStr = Joiner.on("&").withKeyValueSeparator("=").join(paramMap);
        String url = urlPrefix + allParamStr;
        System.out.println(url);
    }

}
