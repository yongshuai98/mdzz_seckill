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
@Table(name = "tb_order_detail")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer orderId;

    private Integer prodId;

    private Integer buyNum;

    private Long buyPrice;

    private String prodName;

    private String prodOptionName;

    private String prodCover;

    private Date createTime;

}
