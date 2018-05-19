package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qjf.demo.entity.WeimobUser;
import com.qjf.demo.mapper.WeimobUserMapper;
import com.qjf.demo.service.WeimobUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-15
 */
@Service
public class WeimobUserServiceImpl extends ServiceImpl<WeimobUserMapper, WeimobUser> implements WeimobUserService {

    public long selectMaxCreateTime(){
        return baseMapper.selectMaxCreateTime();
    }

    public String findUniqueOpenIdByNickname(String nickname) {
        Wrapper wrapper = new EntityWrapper(new WeimobUser());
        wrapper.eq("nickname",nickname);
        WeimobUser user = selectOne(wrapper);
        return null==user ? null : user.getOpenid();
    }

}
