package DAO;


import Model.User;

import java.sql.Connection;

public interface IUserDao {
    /**
     * 判断所输入的账号是否已经存在
     * @param
     * @param account
     * @return
     */
    public User JudgeAccountExist(String account);

    /**
     * 加入一条用户记录
     * @param
     * @return
     */
    public void InsertUser(User user);

    /**
     * 用户登录
     * @return
     */
    public User UserLogin(User user);

}
