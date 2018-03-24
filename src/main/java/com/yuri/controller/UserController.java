package com.yuri.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：UserController   
* 类描述：用户控制器
* 创建时间：2018年3月24日 下午5:43:20
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@WebServlet(urlPatterns = "/user/check")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -6024402299084946359L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从请求中获取参数
		String username = request.getParameter("username");

		// User user = userService.findUserByName(username);

		//这是响应模式为纯文本应答
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 判断条件,想前台输出响应文本
		if ("jack".equalsIgnoreCase(username) || "rose".equalsIgnoreCase(username)) {
			out.print("1");
		} else {
			out.print("0");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
