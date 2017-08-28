package com.xyz.company;

import com.xyz.company.util.HttpRequest;
import com.xyz.company.util.MD5ONCE;


import org.apache.commons.lang3.StringEscapeUtils;

/*一般B2C网银测试程序520100,生成支付报文
 * 仅供测试加密串是否正确，不是模板程序！
 * 默认参数随机生产，使用默认的参数运行结果会有错误，请使用建行业务提供的商户编号等实际参数进行测试
 * 注意：1、公钥与商户POS编号是一一对应的关系，请使用该柜台正确的公钥测试
 *      2、公钥如果重复下载，上一个公钥自动失效。
 *
 * */
public class B2C_Send {
    public static void main(String args[]) {
		/* 可配置的参数 */
        String antiPhishUrl="https://www.baiwandian1.cn/";//防钓鱼地址
        String pub = "4233c7b29ac7efa564b760e1020113";// 公钥后30位
        String merchantID = "105331000001676";// 商户编号
        String orderId = "2015010910921094";// 订单号
        String postId = "002128111";// 商户POS号
        String payment = "0.04";// 金额
        String curCode = "01";// 币种
        String txCode = "520100";// 交易代码
        String clientIp = "";// 网站客户的PC地址
        String regInfo = "abc小飞侠";// 网站客户注册信息，中文需使用escape编码
        String proInfo = "cde充值卡";// 顾客购买的产品的信息，中文需使用escape编码
        String gateway = "";//网关信息（不同的参数表明接口显示网页版还是手机版页面，同时可以控制帐号支付、网银支付等页签，具体参考文档）
        String remark1 = "";//备注1
        String remark2 = "";//备注2
        String referer = "";//商户送空值即可

		/*转译*/
        String escapedRegInfo= StringEscapeUtils.escapeJava(regInfo); //%u5C0F%u98DE%u4FA0;
        String escapedProInfo=StringEscapeUtils.escapeJava(proInfo); //%u5145%u503C%u5361;

		/*计算MAC*/
        String str1 = "MERCHANTID=" + merchantID + "&POSID=" + postId
                + "&BRANCHID=330000000" + "&ORDERID=" + orderId + "&PAYMENT="
                + payment + "&CURCODE=" + curCode + "&TXCODE=" + txCode
                + "&REMARK1=" + remark1 + "&REMARK2=" + remark2 + "&TYPE=1"
                + "&PUB=" + pub + "&GATEWAY=" + gateway + "&CLIENTIP="
                + clientIp + "&REGINFO=" + escapedRegInfo + "&PROINFO=" + escapedProInfo
                + "&REFERER=" + referer;
        System.out.println("1.用于生成MAC的串为：" + str1);
        MD5ONCE mac = new MD5ONCE(str1);
        mac.calc();// md5计算
        String MAC = mac.toString();
        System.out.println("2.生成的MAC为：" + MAC);

		/*最终结果*/
        String result = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain?"
                + "MERCHANTID="
                + merchantID
                + "&POSID="
                + postId
                + "&BRANCHID=330000000"
                + "&ORDERID="
                + orderId
                + "&PAYMENT="
                + payment
                + "&CURCODE="
                + curCode
                + "&TXCODE="
                + txCode
                + "&REMARK1="
                + remark1
                + "&REMARK2="
                + remark2
                + "&TYPE=1"
                + "&GATEWAY="
                + gateway
                + "&CLIENTIP="
                + clientIp
                + "&REGINFO="
                + escapedRegInfo
                + "&PROINFO="
                + escapedProInfo + "&REFERER=" + "&MAC=" + MAC;

        System.out.println("3.实际最后的URL为:\n" + result);
        String[] rsults = result.split("\\?");
        String url = rsults[0];
        String param = rsults[1];
        System.out.println("4.模拟发送HTTP请求网银");
        String result2 = HttpRequest.sendPost(url, param,antiPhishUrl);
        System.out.println("返回数据："+result2);
        //返回结果0130Z110C100 ->MAC计算有问题，检查公钥是否下载正确
        //返回结果0130Z1109001商户地址参数不符，请中止支付并与商户联系确认！->防钓鱼地址有误！请向建行技术人员提供正确的坊钓鱼地址
    }

}