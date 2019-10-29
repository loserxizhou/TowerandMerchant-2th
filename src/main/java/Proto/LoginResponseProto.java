package Proto;
import Enum.ReturnType;
import org.json.JSONObject;

public class LoginResponseProto {

    private ReturnType returnType;
    private String nickName;
    //private byte baseLevel;
    private int coins;
    private int diamonds;
    private String user_uuid;
    //private String email;
    private String roleid;
    private int exp;
    private String tipMsg;

    public LoginResponseProto(ReturnType returnType,String user_uuid,String nickName,int coins,int diamonds,String roleid,int exp)
    {
        this.returnType=returnType;
        this.user_uuid=user_uuid;
        this.tipMsg=null;
        this.nickName=nickName;
        //this.baseLevel=baseLevel;
        this.coins=coins;
        this.diamonds=diamonds;
        //this.email=email;
        this.roleid=roleid;
        this.exp=exp;
    }

    public LoginResponseProto(ReturnType returnType,String tipMsg)
    {
        this.returnType=returnType;
        this.tipMsg=tipMsg;
    }
    /**
     * 封装json数据
     * @param responseProto
     * @return
     */
    public static String packJsonData(LoginResponseProto responseProto,boolean isSuccessful)
    {
        JSONObject jsondata= new JSONObject();
        if(isSuccessful) {
            //如果登录是成功的
            jsondata.put("returnType", responseProto.returnType.ordinal());
            jsondata.put("nickname", responseProto.nickName);
            //jsondata.put("baseLevel", responseProto.baseLevel);
            jsondata.put("baseLevel", 0);
            jsondata.put("coins", responseProto.coins);
            jsondata.put("diamonds", responseProto.diamonds);
            //jsondata.put("roleid", responseProto.roleid);
            jsondata.put("exp", responseProto.exp);
            jsondata.put("user_uuid", responseProto.user_uuid);
            //jsondata.put("email", responseProto.email);
            return jsondata.toString();
        }else {
            //登陆失败时
            jsondata.put("returnType",responseProto.returnType.ordinal());
            jsondata.put("tipMsg",responseProto.tipMsg);
            return jsondata.toString();
        }
    }
}
