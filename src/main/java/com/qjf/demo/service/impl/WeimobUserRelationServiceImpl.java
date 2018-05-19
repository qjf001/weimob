package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qjf.demo.entity.WeimobUserRelation;
import com.qjf.demo.mapper.WeimobUserRelationMapper;
import com.qjf.demo.service.WeimobUserRelationService;
import com.qjf.demo.service.WeimobUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-04-10
 */
@Service
public class WeimobUserRelationServiceImpl extends ServiceImpl<WeimobUserRelationMapper, WeimobUserRelation> implements WeimobUserRelationService {

    @Resource
    private WeimobUserService weimobUserService;

    @Override
    public void save(List<String[]> datas) {
        for(String[] data : datas){
            try {
                String openid1 = weimobUserService.findUniqueOpenIdByNickname(data[0]);
                String openid2 = weimobUserService.findUniqueOpenIdByNickname(data[1]);
                if(null != openid1 && null != openid2){
                    WeimobUserRelation ur = new WeimobUserRelation();
                    ur.setNickname(data[0]);
                    ur.setNicknameOpenid(openid1);
                    ur.setSourceNickname(data[1]);
                    ur.setSourceOpenid(openid2);
                    insert(ur);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
