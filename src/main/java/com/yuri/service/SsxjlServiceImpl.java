package com.yuri.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuri.entity.Area;
import com.yuri.entity.City;
import com.yuri.entity.Province;
import com.yuri.mapper.SsxjlMapper;
import com.yuri.util.MyBatiesUtil;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：SsxjlServiceImpl   
* 类描述：省市县级联业务层的实现类
* 创建时间：2018年3月24日 下午6:06:45
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
public class SsxjlServiceImpl implements SsxjlService {

	@Override
	public List<Province> searchAllProvinces() {
		SqlSession sqlSession = MyBatiesUtil.sqlSession();
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		return ssxjlMapper.selectAllProvinces();
	}

	@Override
	public List<City> searchAllCitiesByProvinceCode(String provinceCode) {
		SqlSession sqlSession = MyBatiesUtil.sqlSession();
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		return ssxjlMapper.selectAllCitiesByProvinceCode(provinceCode);
	}

	@Override
	public List<Area> searchAllAreasByCityCode(String cityCode) {
		SqlSession sqlSession = MyBatiesUtil.sqlSession();
		SsxjlMapper ssxjlMapper = sqlSession.getMapper(SsxjlMapper.class);
		return ssxjlMapper.selectAllAreasByCityCode(cityCode);
	}
}
