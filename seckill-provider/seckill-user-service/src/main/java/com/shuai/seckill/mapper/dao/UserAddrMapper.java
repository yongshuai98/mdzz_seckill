package com.shuai.seckill.mapper.dao;

import com.shuai.seckill.entity.UserAddr;
import com.shuai.seckill.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyongshuai
 * @date 2020/3/18 16:14
 */
@Mapper
@Repository
public interface UserAddrMapper extends BaseMapper<UserAddr> {

    List<UserAddr> selectByUserId(Integer userId);

}
