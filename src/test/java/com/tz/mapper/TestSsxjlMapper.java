package com.tz.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yuri.mapper.SsxjlMapper;
import com.yuri.util.MyBatiesUtil;

public class TestSsxjlMapper {

	private SqlSession sqlSession;

	@Before
	public void setUp() {
		sqlSession = MyBatiesUtil.sqlSession();
	}

	@After
	public void tearDown() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectAllProvinces() {
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		ssxjlMapper.selectAllProvinces().forEach(System.out::println);
	}

	@Test
	public void testSelectAllCitiesByProvinceCode() {
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		ssxjlMapper.selectAllCitiesByProvinceCode("320000").forEach(System.out::println);
	}

	@Test
	public void testSelectAllAreasByCityCode() {
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		ssxjlMapper.selectAllAreasByCityCode("320500").forEach(System.out::println);
	}
}
