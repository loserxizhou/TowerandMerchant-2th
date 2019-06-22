package Proto;

import org.json.JSONObject;

public class LoginRequestProto {
    private String email;
    private String password;

    public String getEmails() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /**
     * 根据json数据生成proto对象
     * @param jsonData
     */
    public LoginRequestProto(String jsonData)
    {
        JSONObject json=new JSONObject(jsonData);
        String email=json.getString("Email");
        String password=json.getString("Password");
        this.email=email;
        this.password=password;
    }
}
