package com.kh.test.user.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.user.model.vo.User;

@Mapper
public interface UserMapper {

//	List<User> userFind(User user);
	User userFind(User user);
	
}
