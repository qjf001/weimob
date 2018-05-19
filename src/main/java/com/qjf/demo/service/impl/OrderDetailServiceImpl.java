package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qjf.demo.entity.OrderDetail;
import com.qjf.demo.mapper.OrderDetailMapper;
import com.qjf.demo.service.OrderDetailService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Resource
    private JdbcTemplate jt;

    @Override
    public void save(List<String[]> datas) {
        jt.execute(" SET IDENTITY_INSERT [dbo].[t_order_detail] OFF ");
        for(String[] data : datas){
            try {
                OrderDetail od = new OrderDetail();
                od.setOrderSn(data[0]);
                od.setProductName(data[1]);
                od.setProductCate(data[2]);
                od.setShoppingOption(data[3]);
                od.setPrice(new BigDecimal(data[4]));
                od.setNum(Double.valueOf(data[5]).intValue());
                od.setSubtotal(new BigDecimal(data[6]));
                od.setMemberAccount(data[7]);
                od.setName(data[8]);
                od.setAddress(data[9]);
                od.setMobile(data[10]);
                od.setZipCode(data[11]);
                od.setLeaveMessage(data[12]);
                od.setDistribution(data[13]);
                od.setDistributionPrice(new BigDecimal(data[14]));
                od.setPayWay(data[15]);
                od.setOrderMemo(data[16]);
                insert(od);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
