package DAO;

import Model.User;
import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class UserDao {
    /**
     * 判断所输入的账号是否已经存在
     * @param conn
     * @param account
     * @return
     */
    public static boolean JudgeAccountExist(Connection conn,String account)
    {
        String selectSqlStr="SELECT * FROM t_user WHERE account=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSqlStr);
            preparedStatement.setString(1,account);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(!resultSet.next())
            {
                resultSet.close();
                preparedStatement.close();
                //说明不存在当前这个账号的记录
                return false;
            }else{
                resultSet.close();
                preparedStatement.close();
                //说明存在当前这个账号的记录
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("判断输入账号是否存在时出现异常，异常信息为："+e);
        }
        return true;//如果该处出现了错误，返回为真，保证后面的逻辑执行不下去
    }

    /**
     * 加入一条用户记录
     * @param conn
     * @param account
     * @param password
     * @return
     */
    public static boolean InsertUser(Connection conn,String account,String password)
    {
        boolean isExist=JudgeAccountExist(conn,account);
        if(!isExist)
        {
            String user_uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String insertSqlStr="INSERT INTO t_user(user_uuid,account,password) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(insertSqlStr);
                preparedStatement.setString(1,user_uuid);
                preparedStatement.setString(2,account);
                preparedStatement.setString(3,password);
                //preparedStatement.setString(3,idcard);
                int effectRows= preparedStatement.executeUpdate();
                preparedStatement.close();
                if(effectRows>0)
                {
                    //说明加入玩家记录成功
                    //为这个玩家创建UserSave记录-先查到这个玩家的id
                    String selectSqlStr="SELECT * FROM t_user WHERE user_uuid=?";
                    PreparedStatement preparedStatement1=conn.prepareStatement(selectSqlStr);
                    preparedStatement1.setString(1,user_uuid);
                    ResultSet resultSet=preparedStatement1.executeQuery();

                    if(resultSet.next())
                    {
                      String useruuid=resultSet.getString("user_uuid");
                      //创建这个用户对应的usersave
                      BaseDao.CreatSaveForUser(conn,useruuid,account);
                    }
                    resultSet.close();
                    preparedStatement1.close();
                }
            }catch (Exception e)
            {
                System.out.println("插入记录时发生异常，异常信息为："+e);
            }
        }else{
            //该记录存在，插入失败
            return false;
        }
        return true;
    }

    /**
     * 用户登录
     * @param conn
     * @param account
     * @param password
     * @return
     */
    public static User UserLogin(Connection conn,String account,String password)
    {
        String selectSqlStr="SELECT * FROM t_user WHERE account=? AND password=?";
        try{
            PreparedStatement preparedStatement=conn.prepareStatement(selectSqlStr);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            User user=null;
            if(resultSet.next())
            {
                String uuid=resultSet.getString("user_uuid");
                String idcard=resultSet.getString("idcard");
                user=new User(uuid,account,password,idcard);
            }
            resultSet.close();
            preparedStatement.close();
            return user;
        }catch (Exception e)
        {
            System.out.println("用户登录时发生异常，异常信息为:"+e);
            return null;
        }
    }
}
