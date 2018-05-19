package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qjf.demo.entity.AdminResource;
import com.qjf.demo.mapper.AdminResourceMapper;
import com.qjf.demo.service.AdminResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表（也叫权限） 服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Service
public class AdminResourceServiceImpl extends ServiceImpl<AdminResourceMapper, AdminResource> implements AdminResourceService {

    public AdminResource findUniqueByUri(String uri) {
        EntityWrapper<AdminResource> wp = new EntityWrapper();
        wp.eq("url",uri);
        return selectOne(wp);
    }
}
