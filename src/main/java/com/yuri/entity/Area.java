package com.yuri.entity;

import lombok.Data;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：Area   
* 类描述：地区的实体类
* 创建时间：2018年3月24日 下午5:44:45
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@Data
public class Area {

	/**
	 * 区域id
	 */
	private Long id;
	/**
	 * 区域代码
	 */
	private String code;
	/**
	 * 区域名称
	 */
	private String name;
	
}
