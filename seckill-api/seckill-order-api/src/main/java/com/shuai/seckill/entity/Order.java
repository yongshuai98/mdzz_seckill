package com.shuai.seckill.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yongshuai
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long orderTotalFee;

    private Long orderActualFee;

    private Integer userId;

    private Integer orderStatus;

    private Date orderCreateTime;

    private Date orderPayTime;

    private Date orderConsignTime;

    private Date orderEndTime;

    private Date orderCloseTime;

}
