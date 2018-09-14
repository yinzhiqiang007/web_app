package com.quinn.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.quinn.app.common.util.RestResult;
import com.quinn.app.model.entity.User;
import com.quinn.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.quinn.app.dao.UserDao;
import com.quinn.BaseServiceImpl;

import java.util.List;

/**
 * @author Quinn
 * @date 2018/1/17
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserDao> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int updateTest(User user) {
        return this.userDao.updateTest(user);
    }

    @Override
    public RestResult getList(User user) {
        Page result = user.initPage();
        List<User> list = userDao.listByEntity(user);

        PageInfo pageInfo = new PageInfo(list);

        return new RestResult("", "", pageInfo);
    }
}
