package com.csii.webhook.controller;

import com.csii.webhook.service.AuthService;
import com.csii.webhook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 571002868
 */
@Controller
public class AuthController {

    /**
    * 跳转登录页面
    *
    */

    /**
     * token私钥
     */

    @RequestMapping("/auth")
    public String auth(String redirect_uri, String client_id, String response_type, String state, Model model){

        model.addAttribute("url",redirect_uri);
        model.addAttribute("state",state);

        System.out.println("auth-----------------------");
        System.out.println("client_id:" + client_id);
        System.out.println("response_type:" + response_type);
        System.out.println("state:" + state);
        System.out.println("redirect_uri" + redirect_uri);

        //平台账户密码认证通过，跳转到登录页面

            return "login";

    }


    @Autowired
    private AuthService authService;
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public String login(String login, String password, String url, String state, Model model){
        String token = authService.sign("csii");
        boolean bool = loginService.login(login,password);
        String urlSplicing=loginService.urlSplicing(bool,url,state,token,model);
        return urlSplicing;
    }

//    @Autowired
//    private AuthService authService;
//    @Autowired
//    private LoginService loginService;
//    @RequestMapping("/login")
//    @ResponseBody
//    public Map<String, Object> login(String login, String password){
//        String token = authService.sign("csii");
//        Boolean bool = loginService.login(login,password);
//
////        String urlSplicing=loginService.urlSplicing(bool,url,state,token,model);
//        Map<String, Object> map = new HashMap<>();
//        map.put("access_token", "");
//        map.put("refresh_token", "refresh123456789");
//        map.put("expires_in", 17600000);
//        return map;
//    }
//    private FindUsersDao dao;
//    @RequestMapping("/login")
//   public String login(String login, String password, String url, String state, Model model)  {
//        Users user = dao.FindUsersDao();
//       if (login.equals(user.getLogin()) && p,passwordassword.equals(user.getPassword()) ){
//           String token = authService.sign("csii");
//           String newUrl = url + "&code=" + token + "&state=" + state;
//           return "redirect:" + newUrl;
//       }else{
//           model.addAttribute("url",url);
//           model.addAttribute("state",state);
//           return "login";
//       }
//
//    }


    @RequestMapping("/consent")
    @ResponseBody
    public Map<String, Object> consent(HttpServletRequest request) {

        String client_id = request.getParameter("client_id");
        String grant_type = request.getParameter("grant_type");
        String client_secret = request.getParameter("client_secret");
        String code = request.getParameter("code");
        String redirect_uri = request.getParameter("redirect_uri");

        System.out.println("client_id\t"+client_id);
        System.out.println("grant_type\t"+grant_type);
        System.out.println("client_secret\t"+client_secret);
        System.out.println("code\t"+code);
        System.out.println("redirect_uri\t"+redirect_uri);

        Map<String, Object> map = new HashMap<>();
        map.put("access_token", code);
        map.put("refresh_token", "refresh123456789");
        map.put("expires_in", 17600000);
        return map;
    }
}
