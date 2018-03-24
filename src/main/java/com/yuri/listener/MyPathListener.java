package com.yuri.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：MyPathListener   
* 类描述：监听器,目的是在项目启动时,把应用路径放入到最大作用域中
* 创建时间：2018年3月24日 下午5:54:21
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@WebListener
public class MyPathListener implements ServletContextListener {

	/* 
	 * context初始化
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String base = context.getContextPath();
		context.setAttribute("base", base);
	}

	/* 
	 * context销毁
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("base");
	}
}
