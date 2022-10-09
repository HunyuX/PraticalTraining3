package com.example.server.controller;

import com.example.server.RedisUtils;
import com.example.server.bean.*;
import com.example.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 *
 * 有关用户信息的业务处理层
 *
 */
@RestController
@RequestMapping("/user")
public class UserManagerController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);

    //服务器，数据库测试连接是否成功的测试函数
    @RequestMapping("/users")
    public User getUser() {
        User user  = userService.selectUserInfo(1);
        user.setUser_name("Jay");
        user.setUser_password("123");
        userService.insertUserN(user);
        return user;
    }


    /**
     *
     * 用户登录
     *
     * 对应前端的 login请求
     * @return
     */
    @RequestMapping(value ="/login",method = RequestMethod.POST)

    @ResponseBody

    public int UserLogin(String username, String password) {

        System.out.println(username);
        System.out.println(password);

        User result = null;
        User user = null;
        user = userService.selectUserInfoN(username);

        if(user != null) {//存在该账户
            if(user.getUser_password().equals(password)) {//密码正确
                result = user;
            } else{//密码错误（对应密码错误）
                return -2;
            }
        }else{//不存在该账户（对应用户名不存在）
            return -1;
        }
        return result.getUser_number();
    }


    //用户注册
    @RequestMapping(value ="/register",method = RequestMethod.POST)

    @ResponseBody
    public String UserRegister(String username, String password, String email) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        User user1 = null;
        User user = userService.selectUserInfo(1);

        //根据传来的用户名在数据库中查找用户
        user1 = userService.selectUserInfoN(username);



        if(user1 != null) {
            //用户已经存在，注册失败
            return "False";
        }else {
            //用户未被注册过，注册该用户
            user.setUser_name(username);
            user.setUser_password(password);
            user.setUser_email(email);
            userService.insertUserN(user);
            return "OK";
        }
    }


    //注销用户
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUser(String username) {
        User user1 = userService.selectUserInfoN(username);
        if (user1 != null) {
            userService.deleteUser(username);
            return true;
        }
        return false;
    }

    //修改密码
    @RequestMapping(value = "/updatepasswordN", method = RequestMethod.POST)
    @ResponseBody
    public boolean updatePasswordN(String username, String password){
        User user1 = null;

        //根据传来的用户id在数据库查找
        user1 = userService.selectUserInfoN(username);
        if(user1 != null) {
            //用户存在，修改密码为传来的密码
            userService.UpdatePasswordN(password, username);
            return true;
        }else {
            return false;
        }
    }

    //修改用户名
    @RequestMapping(value = "/updatename", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateName(String newusername, String email){
        User user = null;
        User user1 = null;

        //根据传来的用户id在数据库查找
        user1 = userService.selectUserInfoE(email);
        if(user1 != null) {
            //用户存在，修改用户名为传来的用户名
            userService.UpdateNameE(newusername,email);
            return true;
        }else {
            //用户不存在，修改用户名失败
            return false;
        }
    }













//    @Resource
//    private RedisUtils redisUtils;
//    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
//
//    //服务器，数据库测试连接是否成功的测试函数
//    @RequestMapping("/users")
//    public User getUser() {
//        User user  = userService.selectUserInfo("1");
//        return user;
//    }
//
//    //Gson gson= JsonBean.getGson();
//    static Gson gson = new GsonBuilder().serializeNulls().create();
//
//    @Autowired
//    private UserService userService;
//
//
//    @Resource
//    private RedisUtils redisUtils;
//    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
//
//
//
//    //用户登陆
//    @PostMapping("/login")
//    public User login(String json){
//        System.out.println(json);
//        User result = null;
//        User user = null;
//        User user1 = null;
//        try{
//            user = gson.fromJson(json,User.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        user1 = userService.selectUserInfoN(user.getUser_name());
//
//        if(user1 != null) {//存在该账户
//            if(user1.getUser_password().equals(user.getUser_password())){//密码正确
//                result = user1;
//            } else{//密码错误，返回用户2（对应密码错误）
//                User usere2 = userService.selectUserInfo(2);
//                return usere2;
//            }
//        }else{//不存在该账户，返回用户1（对应用户名不存在）
//                User usere1 = userService.selectUserInfo(1);
//                return usere1;
//        }
//        return result;
//    }
//
//
//
//
//    //用户注册
//    @PostMapping("/register")
//    public boolean register(String json){
//        User user = null;
//        User user1 = null;
//        //接收前段传来的json的User类
//        try{
//            user = gson.fromJson(json,User.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        //根据传来的用户名在数据库中查找用户
//        user1 = userService.selectUserInfoN(user.getUser_name());
//        if(user1 != null) {
//            //用户已经存在，注册失败
//            return false;
//        }else {
//            //用户未被注册过，注册该用户
//            boolean b = userService.insertUserN(user);
//            return b;
//        }
//    }
//
//
//    //服务器，数据库测试连接是否成功的测试函数
//    @RequestMapping("/users")
//    public User getUser() {
//        User user  = userService.selectUserInfo(3);
//        return user;
//    }
//
//
//    //注销用户
//    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
//    public RespBean deleteUser(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//        }
//        String token = (String)request.get("token");
//        String user = redisUtils.get(token);
//        String data [] = user.split(",");
//        String user_number = data[0];
//        System.out.println(user_number);
//        try {
//            userService.deleteUser(user_number);
//            return new RespBean(1, "删除成功");
//        } catch (Exception e) {
//            return new RespBean(404, "删除失败");
//        }
//    }
//
//    //修改用户名
//    @PostMapping("/updatename")
//    public boolean updateName(String json){
//        User user = null;
//        User user1 = null;
//        try{
//            //接收前段传来的json的User类
//            user = gson.fromJson(json,User.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //根据传来的用户id在数据库查找
//        user1 = userService.selectUserInfo(user.getUser_number());
//        if(user1 != null) {
//            //用户存在，修改用户名为传来的用户名
//            userService.UpdateName(user.getUser_name(),user.getUser_number());
//            return true;
//        }else {
//            //用户不存在，修改用户名失败
//            return false;
//        }
//    }
//
//    //修改密码
//    @PostMapping("/updatepassword")
//    public boolean updatePassword(String json){
//        User user = null;
//        User user1 = null;
//        try{
//            //接收前段传来的json的User类
//            user = gson.fromJson(json,User.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //根据传来的用户id在数据库查找
//        user1 = userService.selectUserInfo(user.getUser_number());
//        if(user1 != null) {
//            //用户存在，修改密码为传来的密码
//            userService.UpdatePassword(user.getUser_password(),user.getUser_number());
//            return true;
//        }else {
//            return false;
//        }
//    }

}
