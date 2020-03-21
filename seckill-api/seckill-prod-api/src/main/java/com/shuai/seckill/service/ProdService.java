package com.shuai.seckill.service;

import com.shuai.seckill.entity.Prod;

import java.util.List;

/**
 * @author yongshuai
 */
public interface ProdService {

    /**
     * 增加商品
     *
     * @param prod 要增加的商品信息
     * @return 增加结果
     */
    Integer saveProd(Prod prod);

    /**
     * 根据 prodId 修改商品
     *
     * @param prod 要修改的商品信息
     * @return 修改结果
     */
    Integer updateProdById(Prod prod);

    /**
     * 根据 prodId 删除商品
     *
     * @param prodId 要删除的商品id
     * @return 删除结果
     */
    Integer deleteProdById(Integer prodId);

    /**
     * 根据 prodId 获取一条商品信息
     *
     * @param prodId 商品id
     * @return 获取结果
     */
    Prod getProdById(Integer prodId);

    /**
     * 获取所有的商品
     *
     * @return 获取结果
     */
    List<Prod> getAllProd();

}
