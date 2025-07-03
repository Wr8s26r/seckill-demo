package com.study.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 
 * @TableName t_seckill_order
 */
@TableName(value ="t_seckill_order")
@EqualsAndHashCode(callSuper = false)
@Data
public class SeckillOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 秒杀商品ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品ID
     */
    private Long goodsId;

}