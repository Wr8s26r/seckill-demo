package com.study.seckill.service;

import com.study.seckill.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.seckill.pojo.User;
import com.study.seckill.vo.GoodsVo;
import com.study.seckill.vo.OrderDetailVo;

/**
* @author DELL
* @description 针对表【t_order】的数据库操作Service
* @createDate 2025-02-21 22:16:51
*/
public interface OrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);

    OrderDetailVo detail(Long orderId);
}
