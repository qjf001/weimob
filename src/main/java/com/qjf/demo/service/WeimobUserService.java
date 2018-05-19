package com.qjf.demo.service;

import com.qjf.demo.entity.WeimobUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QJF
 * @since 2018-03-15
 */
public interface WeimobUserService extends IService<WeimobUser> {

    long selectMaxCreateTime();

    String findUniqueOpenIdByNickname(String datum);
}
