package com.shuai.seckill.service;

import com.shuai.seckill.mapper.dao.ProdImgMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author yongshuai
 */
@Service
public class ProdImgServiceImpl implements ProdImgService {

    @Resource
    private ProdImgMapper prodImgMapper;

}
