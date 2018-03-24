package com.yuri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuri.entity.Area;
import com.yuri.entity.City;
import com.yuri.entity.Province;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：SsxjlMapper   
* 类描述：省市县级联的持久层接口
* 创建时间：2018年3月24日 下午5:57:03
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
public interface SsxjlMapper {

	/**
	 * 持久层的查询所有的省份
	 * @return List<Province> 省份集合
	 */
	List<Province> selectAllProvinces();

	/**
	 * 持久层根据省份代码查询所有城市
	 * @param provinceCode 省份代码
	 * @return List<City> 城市集合
	 */
	List<City> selectAllCitiesByProvinceCode(@Param("provinceCode") String provinceCode);

	/**
	 * 持久层根据城市id查询所有的地区
	 * @param cityCode 城市代码
	 * @return List<Area> 地区集合
	 */
	List<Area> selectAllAreasByCityCode(@Param("cityCode") String cityCode);
}
