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
@Table(name = "tb_user_addr")
public class UserAddr implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverPhone;

    private String province;

    private String city;

    private String county;

    private String town;

    private String detail;

    private Boolean isDefault;

}
