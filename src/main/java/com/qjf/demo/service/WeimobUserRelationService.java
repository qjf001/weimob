package com.qjf.demo.service;

import com.qjf.demo.entity.WeimobUserRelation;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QJF
 * @since 2018-04-10
 */
public interface WeimobUserRelationService extends IService<WeimobUserRelation> {

    void save(List<String[]> datas);
}
