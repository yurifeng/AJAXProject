package com.yuri.entity;

import java.util.List;

import lombok.Data;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：City   
* 类描述：城市的实体类
* 创建时间：2018年3月24日 下午5:52:38
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@Data
public class City {
	
	/**
	 * 城市id
	 */
	private Long id;
	/**
	 * 城市代码
	 */
	private String code;
	/**
	 * 城市名称
	 */
	private String name;
	
	/**
	 * 城市包含区域集合
	 */
	private List<Area> areas;
}
