package com.yuri.util;

import java.io.InputStream;
import java.util.Properties;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：BeanFactory   
* 类描述：BeanFactory工具类,通过代理bean产生所需的实现类,减少层与层之间的代码耦合
* 创建时间：2018年3月24日 下午6:07:20
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
public class BeanFactory {

	private static Properties prop;

	static {
		try {
			prop = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getBean(String key) {
		Object obj = null;
		try {
			Class<?> c = Class.forName(prop.getProperty(key));
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
