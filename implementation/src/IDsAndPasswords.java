import java.util.HashMap;


class IDsAndPasswords {
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDsAndPasswords(){
        loginInfo.put("admin","admin");
        loginInfo.put("youssef","password");
        loginInfo.put("doaa","password");
        loginInfo.put("laila","password");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}