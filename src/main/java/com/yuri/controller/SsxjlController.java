package com.yuri.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuri.entity.Area;
import com.yuri.entity.City;
import com.yuri.entity.Province;
import com.yuri.service.SsxjlService;
import com.yuri.util.BeanFactory;

/**   
*    
* 项目名称：AjaxTeach   
* 类名称：SsxjlController   
* 类描述：省市县级联的控制器
* 创建时间：2018年3月24日 下午5:39:51
* @author: yuriFeng
* 联系方式：yuri_feng@outlook.com 
*      
*/
@WebServlet(urlPatterns = "/ssxjl/*")
public class SsxjlController extends HttpServlet {

	private static final long serialVersionUID = -8047036805836024185L;

	/**
	 * 通过beanFactory代理导入service层对象实例(减少层与层之间的代码耦合)
	 */
	SsxjlService ssxjlService = (SsxjlService) BeanFactory.getBean("ssxjlService");

	/* 
	 * 重写HttpServlet的doGet()方法
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pathInfo = request.getPathInfo();

		String jsonStr = "";
		if ("/getProvince".equals(pathInfo)) {
			List<Province> provinces = ssxjlService.searchAllProvinces();
			// 使用阿里提供的JSON转换工具实现Java对象->JSON数据的转换
			jsonStr = JSON.toJSONString(provinces);
		}

		if ("/getCity".equals(pathInfo)) {
			String provinceCode = request.getParameter("provinceCode");
			List<City> cities = ssxjlService.searchAllCitiesByProvinceCode(provinceCode);
			jsonStr = JSON.toJSONString(cities);
		}
		if ("/getArea".equals(pathInfo)) {
			String cityCode = request.getParameter("cityCode");
			List<Area> areas = ssxjlService.searchAllAreasByCityCode(cityCode);
			jsonStr = JSON.toJSONString(areas);
		}

		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

	/* 
	 * 重写HttpServlet的doPost()方法
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
