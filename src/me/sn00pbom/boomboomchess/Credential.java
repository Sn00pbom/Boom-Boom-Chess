package me.sn00pbom.boomboomchess;

public class Credential {
    private String usrName;
    private String pass;

    public Credential(String usrName, String pass){
        this.usrName = usrName;
        this.pass = pass;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
