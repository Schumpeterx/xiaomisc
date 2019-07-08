package com.classes.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
  	String resource = "mybatis-config.xml";//��src���������xml�ļ�������Ҫ����src�������ᱨ��
	InputStream inputStream = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	SqlSession session = sqlSessionFactory.openSession();
 */

public class DButil {
	private static SqlSessionFactory factory;
	static {
		String resource = "mybatis-config.xml";//�����Ļ�Ĭ�ϴ�src�������ļ�
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
