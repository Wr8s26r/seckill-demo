package com.study.seckill.service;

import com.study.seckill.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author DELL
* @description 针对表【t_goods】的数据库操作Service
* @createDate 2025-02-21 22:19:55
*/
@Service
public interface GoodsService extends IService<Goods> {
//    获取商品列表
    List<GoodsVo> findGoodsVo();
//    获取商品详情页
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
