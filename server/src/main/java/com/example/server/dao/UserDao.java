package com.example.server.dao;

import com.example.server.bean.User;
import com.example.server.bean.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 *
 * mybatis对应数据库用户表的dao层
 * 作为针对用户表的各种业务
 *
 * 查询  插入 更新
 */
@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 查询用户的登陆信息
     *
     * @return
     */
    @Select("SELECT user_number,user_password FROM User")
    List<UserLogin> findAllUserLogin();

    /**
     *
     *
     * 查询某个用户的个人信息
     * @param user_number
     * @return
     */
    @Select("SELECT * FROM user where user_number=#{user_number} ")
    User findUserInfo(@Param("user_number") Integer user_number);

    /**
     *
     *
     * 查询某个用户的个人信息
     * @param user_name
     * @return
     */
    @Select("SELECT * FROM user where user_name=#{user_name} ")
    User findUserInfoN(@Param("user_name") String user_name);

    /**
     *
     *
     * 查询某个用户的个人信息
     * @param user_email
     * @return
     */
    @Select("SELECT * FROM user where user_email=#{user_email} ")
    User findUserInfoE(@Param("user_email") String user_email);


    /**
     * 插入用户信息
     */
    @Insert("insert into  user (user_number,user_name,user_password,user_gender,user_age,user_email) VALUES ( #{user.user_number}, #{user.user_name}, #{user.user_password},#{user.user_gender},#{user.user_age},#{user.user_email})")
    void insertUser(@Param("user") User user);

    /**
     * 插入用户的信息
     */
    @Insert("insert into  user (user_name,user_password,user_email) VALUES ( #{user.user_name}, #{user.user_password}, #{user.user_email})")
    void insertUserN(@Param("user") User user);




    /**
     *
     *修改用户信息
     *
     * @param user_name
     * @param user_gender
     * @param user_number
     * @param user_number
     */
    @Update("update user set user_name = #{user_name}, user_gender = #{user_gender} ,user_number = #{user_number}")
    void UptateUser(@Param("user_name") String user_name, @Param("user_gender") int user_gender,@Param("user_number") String user_number);


//    /**
//     *
//     *
//     * 修改密码
//     *
//     * @param user_password
//     * @param user_number
//     */
//    @Update("update user set user_password = #{user_password} where user_number = #{user_number}")
//    void UptatePassword(@Param("user_password") String user_password, @Param("user_number") Integer user_number);

    /**
     *
     *
     * 修改密码
     *
     * @param user_password
     * @param user_name
     */
    @Update("update user set user_password = #{user_password} where user_name = #{user_name}")
    void UptatePasswordN(@Param("user_password") String user_password, @Param("user_name") String user_name);

    /**
     *
     *
     * 修改用户名
     *
     * @param user_name
     * @param user_number
     */
    @Update("update user set user_name = #{user_name} where user_number = #{user_number}")
    void UptateName(@Param("user_name") String user_name, @Param("user_number") Integer user_number);

    /**
     *
     *
     * 修改用户名
     *
     * @param user_name
     * @param user_email
     */
    @Update("update user set user_name = #{user_name} where user_email = #{user_email}")
    void UptateNameE(@Param("user_name") String user_name, @Param("user_email") String user_email);

    @Delete("delete from user where user_number = #{user_number}")
    void deleteUser(@Param("user_number")String user_number);

    @Delete("delete from user where user_email = #{user_email}")
    void deleteUserE(@Param("user_email")String user_email);

    @Delete("delete from user where user_name = #{user_name}")
    void deleteUserN(@Param("user_name")String user_name);

}
