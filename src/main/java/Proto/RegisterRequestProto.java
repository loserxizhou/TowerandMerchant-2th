package Proto;

import org.json.JSONObject;

public class RegisterRequestProto {
    private String account;
    private String password;

    //public String getEmails() {
    //return email;
    //}
    public String getAccounts() {
        return account;
    }
    public String getPassword() {
        return password;
    }

    /**
     * 根据json数据生成proto对象
     * @param jsonData
     */
    public RegisterRequestProto(String jsonData)
    {
        JSONObject json=new JSONObject(jsonData);
        String account=json.getString("Account");
        String password=json.getString("Password");
        this.account=account;
        this.password=password;
    }
}
