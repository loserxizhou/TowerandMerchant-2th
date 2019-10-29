package Enum;

public enum NetConnectPort {
    Account_Login(1000),
    Account_Change(1001),
    Server_Connect(1002),
    User_Info(1003),
    Account_Register(1004),
    Device_PushInfo(1005),
    Chat_Port(1006),
    Card_Port(1007),
    Fight_PORT(1008),
    Shop_Port(1009),
    Rank_Port(1011),
    Arena_Port(1016),
    Campaign_Stage(1009),
    Email_Port(1015),
    Task_Port(1017),
    Achievement_Port(1018),
    OperationActivity_Port(1020),
    Sign_Port(1021),
    IAP_Port(1022),
    SpaceLab_Port(1023),
    Player_Guide_Step(1024),
    Boss_Challenge(1025),
    Ally_Port(1026),
    Ally_Trade(1027),
    Union_Shop(1028),
    UnionBoss_Port(1029),
    TacticalDrill_Port(1030),
    MineProtection_Port(1031),
    HEAD_CALL(1),
    PING_PORT(2),
    RADIO_PORT(4444);

    private final int value;

    private NetConnectPort(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
