package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper um;

	@Transactional
	@Override
	public void add(User user) {
		um.insertSelective(user);
	}
	@Transactional
	@Override
	public void delete(Integer uid) {
        um.deleteByPrimaryKey(uid);
	}

	@Override
	public void update(User user) {
       um.updateByPrimaryKeySelective(user);
	}
	@Transactional(readOnly = true)
	@Override
	public User findOne(Integer uid) {
         User user = um.selectByPrimaryKey(uid);
		return user;
	}
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
        List<User> list = um.selectByExample(null);
		return list;
	}

}
