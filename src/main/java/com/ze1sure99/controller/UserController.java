package com.ze1sure99.controller;
import com.abc.pay.client.JSON;
import com.abc.pay.client.ebus.PaymentRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user") //一级访问目录
public class UserController {
    @RequestMapping(path="/quick",method = RequestMethod.GET,params = {"accountName"})//二级访问目录
    public String quick(){
        //业务逻辑
        System.out.println("springmvc入门成功");
//        // 设置农行支付请求对象
//        PaymentRequest paymentRequest = new PaymentRequest();
//        //设置订单属性
//        //1.交易类型
//        paymentRequest.dicOrder.put("PayTypeID","ImmediatePay");
//        //2.订单日期
//        paymentRequest.dicOrder.put("OrderDate","2021/12/26");
//        //3.订单时间
//        paymentRequest.dicOrder.put("OrderTime","13:50:43");
//        //4.过期时间
//        paymentRequest.dicOrder.put("ExpiredDate","30");
//        //5.订单编号
//        paymentRequest.dicOrder.put("OrderNo","ON20214652346560301001");
//        //6.交易币种
//        paymentRequest.dicOrder.put("CurrencyCode","156");
//        //7.订单金额
//        paymentRequest.dicOrder.put("OrderAmount","1.00");
//        //8.分期标识
//        paymentRequest.dicOrder.put("InstallmentMark","0");
//        //9.订单种类
//        paymentRequest.dicOrder.put("CommodityType","0599");
//        //将订单明细加入订单中
//        paymentRequest.orderitems.put("OrderItems","中国移动IP卡");
//        //设置支付请求对象的属性
//        //支付类型
//        paymentRequest.dicRequest.put("PaymentType","A");
//        //交易渠道
//        paymentRequest.dicRequest.put("PaymentLinkType","1");
//        //通知方式
//        paymentRequest.dicRequest.put("NotifyType","0");
//        //通知地址
//        paymentRequest.dicRequest.put("ResultNotifyURL","http://localhost:8080/MerchantResult.jsp");
//        //交易是否分账
//        paymentRequest.dicRequest.put("IsBreakAccount","0");
//        //使用支付请求对象的postRequest()方法传送支付请求并取得交易结果对象
//        JSON json = paymentRequest.postRequest();
//        System.out.println(json.GetKeyValue("ReturnCode"));
//        //视图跳转
//        return  "MerchantResult";
           return  "success";
    }
    @RequestMapping("/quick1")
    public String quick1(){
      return  "a";
    }

    @RequestMapping("/quick2")
    public String quick2(){
       return "b";
    }
}
