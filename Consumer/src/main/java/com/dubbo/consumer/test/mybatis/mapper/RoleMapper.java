package com.dubbo.consumer.test.mybatis.mapper;


import com.dubbo.consumer.test.mybatis.pojo.Role;

public interface RoleMapper {

	public Role selectById(long id);
}
