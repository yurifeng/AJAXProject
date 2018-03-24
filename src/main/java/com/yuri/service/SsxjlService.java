package com.yuri.service;

import java.util.List;

import com.yuri.entity.Area;
import com.yuri.entity.City;
import com.yuri.entity.Province;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：SsxjlService   
* 类描述：省市县级联的业务层接口
* 创建时间：2018年3月24日 下午6:03:30
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
public interface SsxjlService {
	
	/**
	 * 业务层搜索所有省份
	 * @return List<Province> 省份集合
	 */
	List<Province> searchAllProvinces();

	/**
	 * 业务层根据省份代码搜索城市
	 * @param provinceCode 省份代码
	 * @return List<City> 城市集合
	 */
	List<City> searchAllCitiesByProvinceCode(String provinceCode);

	/**
	 * 业务层根据城市代码搜索地区
	 * @param cityCode 城市代码
	 * @return List<Area> 区域集合
	 */
	List<Area> searchAllAreasByCityCode(String cityCode);
}
