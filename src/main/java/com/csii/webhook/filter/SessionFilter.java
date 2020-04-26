package com.csii.webhook.filter;



import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName="SessionFilter",urlPatterns="*.do")
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<Object,Object> map = new HashMap<>();
        boolean redis = getRedisResult("127.0.0.1",6379,"bank123456");
        System.out.println(redis);
        if(redis){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            map.put("code","9998");
            map.put("msg","redis服务异常");
            //重置response
            servletResponse.reset();
            //设置编码格式
            servletResponse.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("application/json;charset=UTF-8");

            PrintWriter pw = servletResponse.getWriter();
            pw.write(map.toString());
            pw.flush();
            pw.close();
        }
    }


    public static boolean getRedisResult(String url, int port,String password){
        boolean result = false;
        try {
            //连接本地Redis服务

            Jedis jedis = new Jedis(url, port);
            jedis.auth(password);//密码
            String ping = jedis.ping();
            if (ping.equalsIgnoreCase("PONG")) {
                System.out.println("redis缓存有效！" + ping);
                result = true;
            }
            jedis.close(); // 释放连接资源
        } catch (Exception e) {
            System.out.println("redis缓存失败！");
            result = false;
        }
        return  result;
    }

    @Override
    public void destroy() {

    }
}