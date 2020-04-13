package cn.pojo;

import java.util.Date;

/**
 *员工
 */
public class Staff {
    private Integer id;//主键ID
    private Integer number;//工号
    private String name;//员工姓名
    private String gender;//员工性别
    private String address;//地址
    private String eamil;//电子邮箱
    private Integer age;//员工年龄
    private String phone;//手机号码
    private String toclinic;//所属诊所
    private String position;//职位
    private Integer departmentsid;//所属科室ID
    private Integer roleid;//角色ID
    private String password;//密码
    private Integer creatorid;//创建人ID
    private Integer status;//员工状态 启用/停用 1/0
    private Date createtime;//创建时间
    private Date updatetime;//更新时间
    private Departments departments;
    private Role role;
    private Creation creation;

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Creation getCreation() {
        return creation;
    }

    public void setCreation(Creation creation) {
        this.creation = creation;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToclinic() {
        return toclinic;
    }

    public void setToclinic(String toclinic) {
        this.toclinic = toclinic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDepartmentsid() {
        return departmentsid;
    }

    public void setDepartmentsid(Integer departmentsid) {
        this.departmentsid = departmentsid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
