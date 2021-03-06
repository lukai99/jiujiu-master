package com.jiu.service.impl;

import com.jiu.mapper.TUserMapper;
import com.jiu.model.TUser;
import com.jiu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by lukai on 2018/10/26.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(TUser user) throws Exception {
        if (user.getCreateTime() == null) {
            user.setCreateTime(LocalDateTime.now());
        }

        int i = tUserMapper.insert(user);
        return i;
    }

    @Override
    public List<TUser> queryAll() throws Exception {
        return tUserMapper.selectList(null);
    }
}
