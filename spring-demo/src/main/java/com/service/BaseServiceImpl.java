package com.service;

import com.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/26 20:58
 */

@Service
public class BaseServiceImpl implements IBaseService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void findAllUser() {

    }
}
