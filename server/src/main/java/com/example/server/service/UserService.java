package com.example.server.service;

import com.example.server.bean.User;
import com.example.server.bean.UserLogin;
import com.example.server.dao.UserDao;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 对应userdao的service层
 *
 * 调用userdao关于数据库的操作
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;


    /**
     *
     * 查找所有用户
     * @return
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     *
     * 查找所有用户的登陆信息
     * @return
     */
    public List<UserLogin> selectAllUserLogin() {
        return userDao.findAllUserLogin();
    }


    /**
     *
     * 插入用户  注册
     * @param user
     * @return
     */
   public boolean insertUser(User user)
    {
        userDao.insertUser(user);
        return true;
    }

    /**
     *
     * 注册用户  注册
     * @param user
     * @return
     */
    public boolean insertUserN(User user)
    {
        userDao.insertUserN(user);
        return true;
    }

    /**
     *
     * 通过编号查询某一用户信息
     * @param user_number
     * @return
     */
    public User selectUserInfo(Integer user_number)
    {
        return userDao.findUserInfo(user_number);
    }

    /**
     *
     * 通过电子邮件查询某一用户信息
     * @param user_email
     * @return
     */
    public User selectUserInfoE(String user_email)
    {
        return userDao.findUserInfoE(user_email);
    }


    /**
     *
     * 通过名称查询某一用户信息
     * @param user_name
     * @return
     */
    public User selectUserInfoN(String user_name)
    {
        return userDao.findUserInfoN(user_name);
    }


    /**
     *
     *
     * 更新个人信息
     *
     * @param user_name
     * @param user_gender
     * @param user_number
     */
    public void UpdateUserInfe(String user_name, int user_gender, String user_number)
    {
        userDao.UptateUser(user_name,user_gender,user_number);
    }

//    /**
//     *
//     * 修改密码
//     * @param user_password
//     * @param user_number
//     */
//    public void UpdatePassword(String user_password,Integer user_number)
//    {
//        userDao.UptatePassword(user_password,user_number);
//    }

    /**
     *
     * 修改密码
     * @param user_password
     * @param user_name
     */
    public void UpdatePasswordN(String user_password,String user_name)
    {
        userDao.UptatePasswordN(user_password,user_name);
    }

//    /**
//     *
//     * 修改密码
//     * @param user_password
//     * @param user_email
//     */
//    public void UpdatePasswordE(String user_password,String user_email)
//    {
//        userDao.UptatePasswordE(user_password,user_email);
//    }

    /**
     *
     * 修改用户名
     * @param user_name
     * @param user_number
     */
    public void UpdateName(String user_name,Integer user_number)
    {
        userDao.UptateName(user_name,user_number);
    }

    /**
     *
     * 修改用户名
     * @param user_name
     * @param user_email
     */
    public void UpdateNameE(String user_name,String user_email)
    {
        userDao.UptateNameE(user_name,user_email);
    }

    public void deleteUser(String user_number)
    {
        userDao.deleteUser(user_number);
    }

    public void deleteUserE(String user_email)
    {
        userDao.deleteUserE(user_email);
    }

    public void deleteUserN(String user_name)
    {
        userDao.deleteUserN(user_name);
    }
}
