package com.qjf.demo.service;

import com.qjf.demo.entity.Order;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QJF
 * @since 2018-04-21
 */
public interface OrderService extends IService<Order> {

    void save(List<String[]> datas);
}
