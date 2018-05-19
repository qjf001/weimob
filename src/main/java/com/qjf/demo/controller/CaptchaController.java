package com.qjf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @Author:Tin
 * @Date: create in 2018/1/10 11:16
 * @Description: 登录验证码输出控制类，用于电商管理后台及商户pc版登录校验码请求
 * 如果权限验证
 */
@Controller
@RequestMapping("captcha")
public class CaptchaController {

    @RequestMapping(value = {"get","shiro/get"},method = RequestMethod.GET)
    public void generate(HttpServletResponse response, HttpSession session){
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output).toLowerCase();

        session.setAttribute("captcha", code);

        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘画验证码
     * @param output
     * @return
     */
    private String drawImg(ByteArrayOutputStream output){
        String code = "";
        //随机产生4个字符
        for(int i=0; i<4; i++){
            code += randomChar();
        }
        int width = 90;
        int height = 43;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman",Font.BOLD,25);
        //调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        g.setColor(getRandColor());
        g.setBackground(new Color(255,255,255));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int)x, (int)baseY);

        // 6条随机干扰线
        Random r = new Random ();
        for(int i=0;i<8;i++){
            g.setColor(getRandColor());
            g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
        }

        g.dispose();// 释放资源
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**该方法主要作用是获得随机生成的颜色*/
    public static Color getRandColor(){
        Random r = new Random ();
        int cr = r.nextInt(255),g = r.nextInt(255),b = 0;
        return new Color(cr,g,b);
    }

    /**
     * 随机参数一个字符
     * @return
     */
    private static char randomChar(){
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }

    public static void main(String[] args) {
        Random r = new Random();
        for( int i=0;i<20;i++)
            System.out.println(r.nextInt(1));
    }
}
