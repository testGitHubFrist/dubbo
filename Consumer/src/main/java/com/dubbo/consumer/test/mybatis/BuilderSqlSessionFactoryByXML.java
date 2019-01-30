package com.dubbo.consumer.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import com.dubbo.consumer.test.mybatis.mapper.RoleMapper;
import com.dubbo.consumer.test.mybatis.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;


/**
 * 基于xml构建sqlSessionFactory
 * @author user
 *
 */
public class BuilderSqlSessionFactoryByXML {

	private static Logger logger =Logger.getLogger(BuilderSqlSessionFactoryByXML.class);
	public static void main(String[] args) throws IOException {
		String resource= "mybatis/mybatis-config.xml";
		InputStream inputStream =Resources.getResourceAsStream(resource);
		logger.info("加载配置文件:"+resource);
		SqlSessionFactory sqlSessionFactory =null ;
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		logger.info("构建sqlSessionFactory");
		SqlSession session =sqlSessionFactory.openSession();
		RoleMapper mapper=session.getMapper(RoleMapper.class);
		Role role=mapper.selectById(1);
		logger.info("查询结果："+JSON.toJSONString(role));
	}
}
