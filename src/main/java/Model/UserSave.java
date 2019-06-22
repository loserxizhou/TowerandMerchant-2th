package Model;

public class UserSave {
    private int id;
    private int userid;
    private String nickname="";

    public UserSave(int id, int userid, String nickname, byte baselevel, int coin, int diamond,int roleid,int exp) {
        this.id = id;
        this.userid = userid;
        this.nickname = nickname;
        this.baselevel = baselevel;
        this.coin = coin;
        this.diamond = diamond;
        this.roleid=roleid;
        this.exp=exp;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private byte baselevel;
    private int coin;
    private int diamond;
    private int roleid;
    private int exp;

    public int getRoleid() {
        return roleid;
    }

    public int getExp() {
        return exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public byte getBaselevel() {
        return baselevel;
    }

    public void setBaselevel(byte baselevel) {
        this.baselevel = baselevel;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }
}
