package com.shuai.seckill.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yongshuai
 */
@Data
@Accessors(chain = true)
public class MdzzUserDto implements Serializable {

    private Integer userId;

    private String username;

    private String nickname;

    private String avatar;

    private String token;

    private String role;

}
