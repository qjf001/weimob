package com.qjf.demo.service.impl;

import com.qjf.demo.entity.Order;
import com.qjf.demo.entity.WeimobUserRelation;
import com.qjf.demo.mapper.OrderMapper;
import com.qjf.demo.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-04-21
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    public void save(List<String[]> datas) {
        for(String[] data : datas){
            try {
                Order order = new Order();
                order.setId(data[0]);
                order.setPayTime(sdf.parse(data[1]));
                order.setMemberAccount(data[2]);
                order.setMemberName(data[3]);
                order.setOrderAmount(new BigDecimal(data[4]));
                order.setOrderStatus(data[5]);
                order.setLeaveMessage(data[6]);
                order.setName(data[7]);
                order.setAddress(data[8]);
                order.setMobile(data[9]);
                order.setZipCode(data[10]);
                order.setDistribution(data[11]);
                order.setDistributionPrice(new BigDecimal(data[12]));
                order.setPayWay(data[13]);
                order.setOrderMemo(data[14]);
                insert(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
