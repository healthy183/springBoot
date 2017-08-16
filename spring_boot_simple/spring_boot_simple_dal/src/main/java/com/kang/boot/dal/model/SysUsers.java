package com.kang.boot.dal.model;

public class SysUsers {
    private Integer usrid;

    private String usrname;

    private String usrpwd;

    private Integer usrtype;

    private Integer usrmgr;

    public Integer getUsrid() {
        return usrid;
    }

    public void setUsrid(Integer usrid) {
        this.usrid = usrid;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getUsrpwd() {
        return usrpwd;
    }

    public void setUsrpwd(String usrpwd) {
        this.usrpwd = usrpwd;
    }

    public Integer getUsrtype() {
        return usrtype;
    }

    public void setUsrtype(Integer usrtype) {
        this.usrtype = usrtype;
    }

    public Integer getUsrmgr() {
        return usrmgr;
    }

    public void setUsrmgr(Integer usrmgr) {
        this.usrmgr = usrmgr;
    }
}