//商品
package com.study.seckill.controller;


import com.study.seckill.pojo.User;
import com.study.seckill.service.GoodsService;
import com.study.seckill.service.UserService;
import com.study.seckill.vo.DetailVo;
import com.study.seckill.vo.GoodsVo;
import com.study.seckill.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;


import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/goods")



public class GoodsController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

//优化前QPS 451
        //商品跳转
        @RequestMapping(value = "/toList",produces = "text/html;charset=utf-8")
        @ResponseBody
        public String toList(Model model, User user, HttpServletRequest request, HttpServletResponse response) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String html = (String) valueOperations.get("goodsList");
        if (!StringUtils.isEmpty(html)){
            return html;
        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        //如果为空，手动渲染，存入Redis并返回
//        return "goodsList";

        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(request.getServletContext());
        IServletWebExchange IWebExchange = application.buildExchange(request,response);

        WebContext context = new WebContext(IWebExchange,request.getLocale(),model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsList",context);
        if (!StringUtils.isEmpty(html)){
            valueOperations.set("goodsList",html,60, TimeUnit.SECONDS);
        }
        return html;
    }
    @RequestMapping("/toDetail/{goodsId}")
    @ResponseBody
    public RespBean toDetail(User user, @PathVariable Long goodsId) {
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowdate = new Date();
//        秒杀状态
        int secKillStatus = 0;
        int remainSeconds = 0;
        if(nowdate.before(startDate)){
//            秒杀未开始
            remainSeconds = (int) ((startDate.getTime()-nowdate.getTime()) / 1000);
        }else if(nowdate.after(endDate)){
//            秒杀已结束
            secKillStatus = 2;
            remainSeconds = -1;
        }else {
//            秒杀进行中


            secKillStatus = 1;
            remainSeconds = 0;
        }
//        model.addAttribute("remainSeconds", remainSeconds);
//        model.addAttribute("secKillStatus",secKillStatus);
//        model.addAttribute("goods",goodsVo);
//      return "goodsDetail";
//        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(request.getServletContext());
//        IServletWebExchange IWebExchange = application.buildExchange(request,response);
//
//        WebContext context = new WebContext(IWebExchange,request.getLocale(),model.asMap());
//        html = thymeleafViewResolver.getTemplateEngine().process("goodsDetail",context);
//        if (!StringUtils.isEmpty(html)){
//            valueOperations.set("goodsDetail" + goodsId,html,60, TimeUnit.SECONDS);
//        }
//        return html;
        DetailVo detailVo = new DetailVo();
        detailVo.setGoodsVo(goodsVo);
        detailVo.setUser(user);
        detailVo.setSeckillStatus(secKillStatus);
        detailVo.setRemainSeconds(remainSeconds);

        return RespBean.success(detailVo);
    }
}