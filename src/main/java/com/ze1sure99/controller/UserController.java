package com.ze1sure99.controller;
import com.abc.pay.client.JSON;
import com.abc.pay.client.ebus.PaymentRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("username") //向request域中（model）中存入key为username时，会同步到session域中
@RequestMapping("/user") //一级访问目录
public class UserController {
    @RequestMapping(path="/quick",method = RequestMethod.GET,params = {"accountName"})//二级访问目录
    public String quick(){
        //业务逻辑
        System.out.println("springmvc入门成功");
           return  "success";
    }
    /**
     * 原始servletAPI的获取
     */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }
    /**
     * 通过原始servletAPI进行页面跳转
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//      //借助request对象进行请求转发 一次请求
//      request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
         response.setContentType("text/html;charset=utf-8");
        //直接返回数据
        response.getWriter().write("拉勾网");
        //借助response对象完成重定向  两次请求 WEB-INF:安全目录:不允许外部请求直接访问该目录资源，只可以进行服务器内部跳转
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    /**
     * 演示forward转发
     */
    @RequestMapping("/forward")
    public String forward(Model model) {
        //还想在模型中设置一些值怎么做？
        model.addAttribute("username","ze1sure99");
        //使用请求转发，既可以转发到jsp,也可以转发到其他的控制器方法
        //return "forward:/product/findAll";
        return "forward:/WEB-INF/pages/success.jsp";
    }
    /**
     * @SessionAttributes的效果：多个请求之间共享数据
     */
    @RequestMapping("/returnString")
    public String retrunString(){
        return "success";
    }
    /**
     * 演示Redirect关键字进行重定向
     * 当写了redirect或者forward关键字，是不会在走视图解析器了
     */
    @RequestMapping("/redirect")
    public String redirect(Model model){
        //底层使用的还是request.setAttribute("username","ze1sure99") 域范围:一次请求
        model.addAttribute("username","ze1sure99");
        return "redirect:/index.jsp";
    }
    /**
     * modelAndView进行页面跳转:方式一
     */
    @RequestMapping("/returnModelAndView1")
    public ModelAndView returnModelAndView1(){
        /**
         * model:模型 作用：封装存放数据
         * view:视图  用来展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","方式一");
        //设置视图名称  视图解析器解析modelAndView 拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }
    /**
     * modelAndView进行页面跳转:方式二
     */
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView){
        /**
         * model:模型 作用：封装存放数据
         * view:视图  用来展示数据
         */
        //设置模型数据
        modelAndView.addObject("username","方式二");
        //设置视图名称  视图解析器解析modelAndView 拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }


}
