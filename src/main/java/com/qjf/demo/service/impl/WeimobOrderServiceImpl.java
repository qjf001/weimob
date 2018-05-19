package com.qjf.demo.service.impl;

import com.qjf.demo.entity.WeimobOrder;
import com.qjf.demo.mapper.WeimobOrderMapper;
import com.qjf.demo.service.WeimobOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-16
 */
@Service
public class WeimobOrderServiceImpl extends ServiceImpl<WeimobOrderMapper, WeimobOrder> implements WeimobOrderService {

    @Override
    public String selectMaxCreateTime() {
        return baseMapper.selectMaxCreateTime();
    }
}
