package Proto;
import org.json.JSONObject;

public class BuildingsRequestProto {
    private String buildingName;
    private String buildingType;

    public String getBuildingName() {
        return buildingName;
    }
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * 根据json数据生成proto对象
     * @param jsonData
     */
    public BuildingsRequestProto(String jsonData)
    {
        JSONObject json=new JSONObject(jsonData);
        String buildingname=json.getString("buildingName");
        String buildingtype=json.getString("buildingType");
        this.buildingName=buildingname;
        this.buildingType=buildingtype;
    }
}
