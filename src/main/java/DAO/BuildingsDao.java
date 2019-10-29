package DAO;

import Model.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class BuildingsDao {
    /**
     * 创建建筑，保存在t_xxx_building表中，同时建立中间表t_base_xxx_building
     * @param conn
     * @param user_uuid
     */
    public static void CreatSaveForUser(Connection conn,String user_uuid,String user_name)
    {
        //首先创建对应玩家的base记录
        String base_uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String selectSqlStr="INSERT INTO t_base(base_uuid,user_name) VALUES (?,?)";
        try{
            PreparedStatement preparedStatement=conn.prepareStatement(selectSqlStr);
            preparedStatement.setString(1,base_uuid);
            preparedStatement.setString(2,user_name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e)
        {
            System.out.println("创建用户数据t_base时出现异常，异常信息为"+e);
        }

        //再建立该玩家的user和base中间表记录
        String user_base_uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String insertSqlStr="INSERT INTO t_user_base(user_base_uuid,user_uuid,base_uuid) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement=conn.prepareStatement(insertSqlStr);
            preparedStatement.setString(1,user_base_uuid);
            preparedStatement.setString(2,user_uuid);
            preparedStatement.setString(3,base_uuid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e)
        {
            System.out.println("创建用户数据t_user_base时出现异常，异常信息为"+e);
        }
    }

    /**
     * 通过用户的id获得用户的数据t_base
     * @param conn
     * @param user_uuid
     * @return
     */
    public static Base GetUserSaveByUserid(Connection conn,String user_uuid)
    {
        String selectSqlStr =
                "SELECT * " +
                        "FROM t_base , t_user_base , t_user " +
                        "WHERE " +
                        "t_user.user_uuid = t_user_base.user_uuid " +
                        "AND " +
                        "t_base.base_uuid = t_user_base.base_uuid " +
                        "AND " +
                        "t_user.user_uuid = ? ";
        try{
            PreparedStatement preparedStatement=conn.prepareStatement(selectSqlStr);
            preparedStatement.setString(1,user_uuid);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String baseid = resultSet.getString("base_uuid");
                //int userlevel = resultSet.getInt("user_level");
                int userlevel = 0;
                String nickname = resultSet.getString("user_name");
                int coin=resultSet.getInt("gold");
                int diamond=resultSet.getInt("diamond");
                //int exp=resultSet.getInt("exp");
                int exp=0;
                int wood=resultSet.getInt("wood");
                int iron=resultSet.getInt("iron");
                int wheat=resultSet.getInt("wheat");
                resultSet.close();
                preparedStatement.close();
                Base base=new Base(baseid,nickname,userlevel,coin,diamond,exp,wood,iron,wheat);
                return base;
            }
        }catch (Exception e)
        {

            System.out.println("获得用户数据t_base出现异常，异常信息为"+e);

        }
        return null;
    }

    /**
     * 通过用户的id来修改用户的游戏昵称
     * @param conn
     * @param base_uuid
     * @param newNickName
     * @return
     */
    public static boolean UpdateNickNameByUserid(Connection conn,String base_uuid,String newNickName)
    {
        String updateSqlStr="UPDATE t_base SET user_name=? WHERE base_uuid=?";
        try{
            PreparedStatement preparedStatement=conn.prepareStatement(updateSqlStr);
            preparedStatement.setString(1,newNickName);
            preparedStatement.setString(2,base_uuid);
            int effectRows=preparedStatement.executeUpdate();
            preparedStatement.close();
            if(effectRows>0)
            {
                return true;
            }else {
                return false;
            }
        }catch (Exception e)
        {
            System.out.println("更新玩家昵称时发生异常，异常信息为:"+e);
            return false;
        }
    }
}
