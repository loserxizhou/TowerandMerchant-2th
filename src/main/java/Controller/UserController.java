package Controller;

import DAO.UserDao;
import DAO.BaseDao;
import EmailVerifySystem.Email;
import Handler.Request;
import Model.User;
import Model.Base;
import Proto.*;

import Servers.Client;
import Servers.Server;
import io.netty.channel.Channel;
import Enum.ReturnType;
import Enum.ActionType;
import java.util.Random;
import Enum.RequestType;

public class UserController extends BaseController {

    public UserController()
    {
        requestType= RequestType.User;
    }

    /**
     * 注册请求
     * @param jsonData
     * @param channel
     * @param server
     * @return
     */
    public String Register(String jsonData,Channel channel,Server server)
    {
        Client client=server.clientDictionary.get(channel);
        //解析json
        RegisterRequestProto registerRequestProto=new RegisterRequestProto(jsonData);
        String account=registerRequestProto.getAccounts();
        String password=registerRequestProto.getPassword();
        //解析data
        /*
        String[] strArr=data.split("#");
        String account=strArr[0];
        String password=strArr[1];
         */
        if(UserDao.InsertUser(client.getMysqlConn(),account,password)) {
            RegisterResponseProto registerSuccessfulResponseProto = new RegisterResponseProto(ReturnType.Successful);
            String responseJsonData = RegisterResponseProto.packJsonData(registerSuccessfulResponseProto, true);
            return responseJsonData;
        }else{
            //登录失败
            RegisterResponseProto registerFailedResponseProto = new RegisterResponseProto(ReturnType.Failed,"密码错误");
            String responseJsonData=RegisterResponseProto.packJsonData(registerFailedResponseProto,false);
            return responseJsonData;
        }
    }

    /**
     * 用户登录
     * @param jsonData
     * @param channel
     * @param server
     * @return
     */
    public String Login(String jsonData,Channel channel,Server server)
    {
        Client client=server.clientDictionary.get(channel);
        //解析json
        LoginRequestProto loginRequestProto=new LoginRequestProto(jsonData);
        String account=loginRequestProto.getAccounts();
        String password=loginRequestProto.getPassword();
        User user=UserDao.UserLogin(client.getMysqlConn(),account,password);
        if(user!=null)
        {
            //说明登录成功
            //查询他的记录
            Base base = BaseDao.GetUserSaveByUserid(client.getMysqlConn(),user.getUuid());
            /*
            if(base.getUsername().equals("") ||base.getUsername()==null)
            {
                //没有nickname时使用account
                //int coins,int diamonds,int userid,String email,int roleid,int exp
                LoginResponseProto loginSuccessfulResponseProto=new LoginResponseProto(ReturnType.Successful,user.getUuid(),user.getAccount(),base.getCoin(),base.getDiamond(),base.getExp());
                String responseJsonData=LoginResponseProto.packJsonData(loginSuccessfulResponseProto,true);
                return responseJsonData;
            }else{

             */
                //有nickname
                LoginResponseProto loginSuccessfulResponseProto=new LoginResponseProto(ReturnType.Successful,user.getUuid(),base.getUsername(),base.getCoin(),base.getDiamond(),user.getUuid(),base.getExp());
                String responseJsonData=LoginResponseProto.packJsonData(loginSuccessfulResponseProto,true);
                return responseJsonData;
            //}
        }else{
            //登录失败
            LoginResponseProto loginFailedResponseProto=new LoginResponseProto(ReturnType.Failed,"密码错误");
            String responseJsonData=LoginResponseProto.packJsonData(loginFailedResponseProto,false);
            return responseJsonData;
        }
    }

    /**
     * 更新游戏内昵称
     * @param data
     * @param channel
     * @param server
     * @return
     */
    public String UpdateNickName(String data,Channel channel,Server server)
    {
        Client client=server.clientDictionary.get(channel);
        String []dataStrArr=data.split("#");
        String useid=dataStrArr[0];
        String nickname=dataStrArr[1];
        boolean isSuccessful=BaseDao.UpdateNickNameByUserid(client.getMysqlConn(),useid,nickname);
        if(isSuccessful)
        {
            return String.valueOf(ReturnType.Successful.ordinal());
        }else {
            return String.valueOf(ReturnType.Failed.ordinal());
        }
    }
}
