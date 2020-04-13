package cn.pojo;

import java.util.Date;

/**
 * 科室
 */
public class Departments {
    private Integer id;//主键ID
    private Integer number;//科室编号
    private String name;//科室名称
    private String intro;//科室简介
    private Integer creatorid;//创建人ID
    private Integer status;//科室状态 启用/停用 1/0
    private Date createtime;//创建时间
    private Date updatetime;//更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public String getStatus() {
        if (this.status == 0) {
            return "停用";
        }else if(this.status == 1){
            return "启用";
        }
        return "";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
