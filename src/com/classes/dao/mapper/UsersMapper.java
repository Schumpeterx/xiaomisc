package com.classes.dao.mapper;

import java.util.List;

import com.classes.dao.vo.Goods;
import com.classes.dao.vo.Users;

public interface UsersMapper {
	public Users login(Users u);
	public int insertUsers(Users u);
	public Goods selectGoods(int gid);
	public List<Goods> listGoods();
}
