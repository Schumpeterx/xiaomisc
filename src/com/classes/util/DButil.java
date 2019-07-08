package com.classes.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
  	String resource = "mybatis-config.xml";//在src里面找这个xml文件，所以要放在src里面否则会报错
	InputStream inputStream = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	SqlSession session = sqlSessionFactory.openSession();
 */

public class DButil {
	private static SqlSessionFactory factory;
	static {
		String resource = "mybatis-config.xml";//这样的话默认从src里面找文件
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null) {
				
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
}
