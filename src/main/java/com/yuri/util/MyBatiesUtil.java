package com.yuri.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：MyBatiesUtil   
* 类描述：持久层框架Mybatis的工具类
* 创建时间：2018年3月24日 下午6:08:52
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
public class MyBatiesUtil {

	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try (InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sqlSessionFactory产生sqlSession
	 * @return sqlSession
	 */
	public static SqlSession sqlSession() {
		return sqlSessionFactory == null ? null : sqlSessionFactory.openSession();
	}

	/**
	 * 关闭sqlSession
	 * @param sqlSession
	 */
	public static void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
	}
}
