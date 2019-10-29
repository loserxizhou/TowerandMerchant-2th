package Proto;
import Enum.ReturnType;
import org.json.JSONObject;

public class BuildingsResponseProto {
    private ReturnType returnType;
    private int buildingLevel;
    private int fieldID;
    private int resourcesType;
    private int resources;
    private String tipMsg;

    public BuildingsResponseProto(ReturnType returnType)
    {
        this.returnType=returnType;
    }

    public BuildingsResponseProto(ReturnType returnType,String tipMsg)
    {
        this.returnType=returnType;
        this.tipMsg=tipMsg;
    }

    /**
     * 封装json数据
     * @param responseProto
     * @return
     */
    public static String packJsonData(BuildingsResponseProto responseProto,boolean isSuccessful)
    {
        JSONObject jsondata= new JSONObject();
        if(isSuccessful) {
            //如果登录是成功的
            jsondata.put("returnType", responseProto.returnType.ordinal());
            jsondata.put("fieldID", responseProto.fieldID);
            jsondata.put("buildingLevel", responseProto.buildingLevel);
            jsondata.put("resourcesType", responseProto.resourcesType);
            jsondata.put("resources", responseProto.resources);
            return jsondata.toString();
        }else {
            //登陆失败时
            jsondata.put("returnType",responseProto.returnType.ordinal());
            jsondata.put("tipMsg",responseProto.tipMsg);
            return jsondata.toString();
        }
    }
}
