package Controller;

import Servers.Server;
import io.netty.channel.Channel;
import Enum.RequestType;

//这是基类Controller，不是Base对象的Controller
public class BaseController {
    public RequestType requestType= RequestType.None;

    public String DefaultHandle(String data, Channel clientChannel, Server server)
    {
        return null;
    }
}
