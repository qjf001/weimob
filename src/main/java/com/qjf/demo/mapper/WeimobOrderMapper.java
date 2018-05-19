package com.qjf.demo.mapper;

import com.qjf.demo.entity.WeimobOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author QJF
 * @since 2018-03-16
 */
public interface WeimobOrderMapper extends BaseMapper<WeimobOrder> {
    String selectMaxCreateTime();
}
