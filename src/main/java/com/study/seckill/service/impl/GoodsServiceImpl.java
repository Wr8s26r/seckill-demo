package com.study.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.seckill.pojo.Goods;
import com.study.seckill.service.GoodsService;
import com.study.seckill.mapper.GoodsMapper;
import com.study.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author DELL
* @description 针对表【t_goods】的数据库操作Service实现
* @createDate 2025-02-21 22:19:55
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;
//    获取商品列表
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }
//    获取商品详情页
    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}




