package cn.pojo;

import java.util.Date;

/**
 * 处方模板
 */
public class PrescriptionTemplate {
    private Integer id;//主键ID
    private String number;//模板编号
    private String name;//模板名称
    private String type;//处方类型
    private String diagnose;//诊断
    private String jurisdiction;//模板权限
    private Date createtime;//创建时间
    private Date updatetime;//更新时间
    private Integer staffid;//创建人ID
    private String describe;//处方描述

    private Staff staff;//员工类

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public PrescriptionTemplate(String number, String name, String type, String diagnose
            , String jurisdiction, Date createtime, String describe) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.diagnose = diagnose;
        this.jurisdiction = jurisdiction;
        this.createtime = createtime;
        this.describe = describe;
    }

    public PrescriptionTemplate() {
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }
}
