package com.classes.service;

import org.apache.ibatis.session.SqlSession;

import com.classes.dao.mapper.UsersMapper;
import com.classes.dao.vo.Goods;
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
	
	
	public int selectid(Users u) {
		SqlSession session=DButil.getSession();
		UsersMapper um=session.getMapper(UsersMapper.class);
		int id=um.selectid(u);
		return id;
	}
	
	public Goods selectGoods(int gid) {
		SqlSession session=DButil.getSession();
		UsersMapper um=session.getMapper(UsersMapper.class);
		Goods goods=new Goods();
		goods=um.selectGoods(gid);
		session.close();
		return goods;
	}
	public Users selectUser(int uid) {
		SqlSession session = DButil.getSession();
		UsersMapper um = session.getMapper(UsersMapper.class);
		Users usr = new Users();
		usr = um.selectUser(uid);
		session.close();
		return usr;
	}
	
}
