package com.kder.business.actions.validatecode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kder.business.actions.common.BaseController;
import com.kder.business.actions.user.UserController;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.ValidateCodeGenetor;
import com.kder.web.contants.WebContants;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/** 
 * 账户处理器，注册、登录等
 * @author parudy
 * @date 2018年3月24日 
 * @version v1.0
 */
@RestController
@RequestMapping("/validatecode")
public class ValidateCodeController  extends BaseController {

	 private final static Logger logger = Logger.getLogger(ValidateCodeController.class);
	
//	/**
//	 * 响应验证码页面
//	 * @return
//	 */
//	@RequestMapping(value="/getValidateCode")
//	public void getValidateCode(HttpServletRequest request,
//			                 	HttpServletResponse response) throws Exception{
//		
//		// 设置响应的类型格式为图片格式
//		response.setContentType("image/jpeg");
//		//禁止图像缓存。
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
//
//		
//		String page = getString("page");
//		Assert.hasText(page, "缺少page参数");
//		
//		HttpSession session = request.getSession();
//
//		ValidateCodeGenetor vCode = new ValidateCodeGenetor(90,40,5,100);
//		logger.info("验证码："+vCode.getCode());
//		session.setAttribute(WebContants.validateCode, WebContants.validateCode+page+vCode.getCode());
//		vCode.write(response.getOutputStream());
//	}
	
	
	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/getValidateCode")
	public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		logger.debug("获取图片验证码:ImageCodeController:imageCode........");
		// 在内存中创建图象
		int width = 65, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(230, 255));
		g.fillRect(0, 0, 100, 25);
		// 设定字体
		g.setFont(new Font("Arial", Font.CENTER_BASELINE | Font.ITALIC, 18));
		// 产生0条干扰线，
		g.drawLine(0, 0, 0, 0);
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(getRandColor(100, 150));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 15 * i + 6, 16);
		}
		for (int i = 0; i < (random.nextInt(5) + 5); i++) {
			g.setColor(new Color(random.nextInt(255) + 1, random.nextInt(255) + 1, random.nextInt(255) + 1));
			g.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
		}
		
		
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		
		String page = getString("page");
		Assert.hasText(page, "缺少page参数");
		
		HttpSession session = request.getSession();

		logger.info("验证码："+sRand);
		session.setAttribute(WebContants.validateCode, WebContants.validateCode+page+sRand);
		
		
		// 图象生效
		g.dispose();
		ServletOutputStream responseOutputStream = response.getOutputStream();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", responseOutputStream);
		// 以下关闭输入流！
		responseOutputStream.flush();
		responseOutputStream.close();				
		
	}
	
	
	
	/**
	 * 给定范围获得随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	
	/**
	 * 响应验证码页面
	 * @return
	 */
	@RequestMapping(value="/checkValidateCode")
	public Result<?> checkValidateCode(HttpServletRequest request,
			                 		   HttpServletResponse response){
		return super.checkValidateCode();
	}
}
