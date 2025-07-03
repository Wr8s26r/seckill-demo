package com.study.seckill.mapper;

import com.study.seckill.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.seckill.vo.GoodsVo;

import java.util.List;

/**
* @author DELL
* @description 针对表【t_goods】的数据库操作Mapper
* @createDate 2025-02-21 22:19:55
* @Entity com.study.seckill.pojo.Goods
*/
public interface GoodsMapper extends BaseMapper<Goods> {
    //获取商品列表
    List<GoodsVo> findGoodsVo();
    //获取商品详情页
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}




