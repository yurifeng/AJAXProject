package com.yuri.entity;

import java.util.List;

import lombok.Data;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：Province   
* 类描述：省份实体类
* 创建时间：2018年3月24日 下午5:53:31
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@Data
public class Province {

	/**
	 * 省份id
	 */
	private Long id;
	/**
	 *省份代码 
	 */
	private String code;
	/**
	 * 省份名称
	 */
	private String name;

	/**
	 * 省份包含城市集合
	 */
	private List<City> cities;
}
