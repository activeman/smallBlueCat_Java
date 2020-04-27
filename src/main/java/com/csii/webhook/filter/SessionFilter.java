package com.csii.webhook.filter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 交易执行前验证redis服务是否正常
 *
 * @WebFilter用于将一个类声明为过滤器
 * @Order(1)设置过滤器的执行顺序数字越小越先执行
 */
@Order(1)
@WebFilter(filterName = "SessionFilter", urlPatterns = "*.do")
public class SessionFilter implements Filter {

    @Value("${spring.redis.host}")
    private String url;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${webhook.redis.verification}")
    private boolean verification;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("connect-->url:" + url + "\tport:" + port + "\tpassword:" + password);
        //添加开始redis服务验证按钮标签
        if (!verification) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        boolean redis = getRedisResult(url, port, password);
        if (redis) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            errorResponse(servletResponse, "9998", "redis服务异常");
        }
    }

    @Override
    public void destroy() {

    }

    public static void errorResponse(ServletResponse servletResponse, String code, String msg) throws IOException {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
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

    //是否开启redis服验证
    public static void openRedisVerificate(String url, int port, String password, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<Object, Object> map = new HashMap<>();
        boolean redis = getRedisResult(url, port, password);
        System.out.println(redis);
        if (redis) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            map.put("code", "9998");
            map.put("msg", "redis服务异常");
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

    //判断 redis服务是否正常
    public static boolean getRedisResult(String url, int port, String password) {
        boolean result = false;
        try {
            //连接本地Redis服务
            Jedis jedis = new Jedis(url, port);
            if (password.length() > 0) {
                jedis.auth(password);//密码
            }
            String ping = jedis.ping();
            if (ping.equalsIgnoreCase("PONG")) {
                System.out.println("redis缓存有效！" + ping);
                result = true;
            }
            jedis.close(); // 释放连接资源
        } catch (Exception e) {
            System.out.println("redis缓存失败！");
        }
        return result;
    }

}
