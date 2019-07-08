package com.classes.service;

import org.apache.ibatis.session.SqlSession;

import com.classes.dao.mapper.UsersMapper;
import com.classes.dao.vo.Users;
import com.classes.util.DButil;


public class UsersService {
	public Users login(Users u) {
		SqlSession session=DButil.getSession();
		UsersMapper um=session.getMapper(UsersMapper.class);
		return um.login(u);
	}
	
	public int addUser(Users u) {
		SqlSession session=DButil.getSession();
		UsersMapper um=session.getMapper(UsersMapper.class);
		int i=um.insertUsers(u);
		session.commit();
		session.close();
		return i;
	}
	
}
