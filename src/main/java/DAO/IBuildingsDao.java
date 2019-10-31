package DAO;

import Model.User;

import java.sql.Connection;

public interface IBuildingsDao {
    /**
     * 创建建筑，保存在t_xxx_building表中，同时建立中间表t_base_xxx_building
     */
    public void CreatSaveForUser(User user);
}
