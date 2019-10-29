package Controller;

import DAO.BuildingsDao;
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

//主基地建筑请求
public class BuildingsController extends BaseController {
    public BuildingsController(){ requestType = RequestType.Buildings; }
    /**
     * 请求建筑数据
     */
    public String BuildingsData(String jsonData,Channel channel,Server server)
    {
        Client client=server.clientDictionary.get(channel);
        //解析json
        BuildingsRequestProto buildingsRequestProto=new BuildingsRequestProto(jsonData);
        String buildingName=buildingsRequestProto.getBuildingName();
        String buildingType=buildingsRequestProto.getBuildingType();
        //return对象为jsondata
        return null;
    }
}
