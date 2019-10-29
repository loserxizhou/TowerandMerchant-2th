package Model;

public class User {
    private String uuid;
    private String account;
    private String password;
    private String idcard;

    public User(String uuid,String account,String password,String idcard)
    {
        this.uuid=uuid;
        this.account=account;
        this.password=password;
        this.idcard=idcard;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
