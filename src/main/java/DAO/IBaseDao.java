package DAO;

import Model.Base;
import Model.User_base_middle;

import java.sql.Connection;

public interface IBaseDao {
    /**
     * 创建用户的基本数据，保存在t_base表中
     */
    public void CreatSaveForUser(Base base);

    /**
     * 建立中间表t_user_base(与创建用户基本数据一同使用)
     */
    public void CreatSaveMiddle(User_base_middle ub);

    /**
     * 通过用户的id获得用户的数据t_base
     * @param user_uuid
     * @return
     */
    public Base GetUserSaveByUserid(String user_uuid);

    /**
     * 通过用户的id来修改用户的游戏昵称
     * 传入的值是封装的用户ID和所要更改的游戏昵称
     * @param base
     * @return
     */
    public int UpdateNickNameByUserid(Base base);
}
