package com.qjf.demo.mapper;

import com.qjf.demo.entity.WeimobUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author QJF
 * @since 2018-03-15
 */
public interface WeimobUserMapper extends BaseMapper<WeimobUser> {

    public long selectMaxCreateTime();

}
