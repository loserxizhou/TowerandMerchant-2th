package Proto;
import Enum.ReturnType;
import org.json.JSONObject;

public class RegisterResponseProto {

    private ReturnType returnType;
    private String tipMsg;

    public RegisterResponseProto(ReturnType returnType)
    {
        this.returnType=returnType;
    }

    public RegisterResponseProto(ReturnType returnType,String tipMsg)
    {
        this.returnType=returnType;
        this.tipMsg=tipMsg;
    }
    /**
     * 封装json数据
     * @param responseProto
     * @return
     */
    public static String packJsonData(RegisterResponseProto responseProto,boolean isSuccessful)
    {
        JSONObject jsondata = new JSONObject();
        if(isSuccessful) {
            //如果注册是成功的
            jsondata.put("returnType", responseProto.returnType.ordinal());
            return jsondata.toString();
        }else {
            //注册失败时
            jsondata.put("returnType",responseProto.returnType.ordinal());
            jsondata.put("tipMsg",responseProto.tipMsg);
            return jsondata.toString();
        }
    }
}
