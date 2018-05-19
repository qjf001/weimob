package com.qjf.demo.service;

import com.qjf.demo.entity.WeimobOrder;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QJF
 * @since 2018-03-16
 */
public interface WeimobOrderService extends IService<WeimobOrder> {

    String selectMaxCreateTime();
}
