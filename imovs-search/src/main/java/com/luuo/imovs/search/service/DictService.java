package com.luuo.imovs.search.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.luuo.imovs.search.entity.CustomDict;
import com.luuo.imovs.search.mapper.CustomDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictService {

    @Autowired
    private CustomDictMapper customDictMapper;

    public List<CustomDict> getCustomDict() {
        LambdaQueryWrapper<CustomDict> queryWrapper = Wrappers.<CustomDict>lambdaQuery()
                .eq(CustomDict::getDictType, 0)
                .orderByDesc(CustomDict::getLastModifyTime);
        return customDictMapper.selectList(queryWrapper);
    }
}
