package com.classes.dao.mapper;

import com.classes.dao.vo.Users;

public interface UsersMapper {
	public Users login(Users u);
	public int insertUsers(Users u);
}
