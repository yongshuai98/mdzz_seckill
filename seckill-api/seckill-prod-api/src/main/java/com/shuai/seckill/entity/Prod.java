package com.shuai.seckill.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yongshuai
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_prod")
public class Prod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prodName;

    private String prodCover;

    private Integer prodPrice;

}
