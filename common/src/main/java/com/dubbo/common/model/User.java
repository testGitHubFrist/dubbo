package com.dubbo.common.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/18.
 */
public class User implements Serializable {

    private int id;

    private String uid;

    private String loginAccount;

    private String name;

    private String password;

    private String phone;

    private String email;

    private String createDate;

    private String updateDate;

    private String createBy;

    private String updateBy;

    private String lastLoginDate;

    private String lastLoginIp;

    private String lastLoginArea;

    private String memo;

    private String source;

    private String orgId;

    private String status;//用户状态；0:无效，1:有效；2：注册待审核；3：注册申请审核未通过

    private int role;

    private int registerType;

    private String registerApprover;

    private String registerApprovalOpinion;

    private String registerApproverDate;


    public String getRegisterApprover() {
        return registerApprover;
    }

    public void setRegisterApprover(String registerApprover) {
        this.registerApprover = registerApprover;
    }

    public String getRegisterApprovalOpinion() {
        return registerApprovalOpinion;
    }

    public void setRegisterApprovalOpinion(String registerApprovalOpinion) {
        this.registerApprovalOpinion = registerApprovalOpinion;
    }

    public String getRegisterApproverDate() {
        return registerApproverDate;
    }

    public void setRegisterApproverDate(String registerApproverDate) {
        this.registerApproverDate = registerApproverDate;
    }

    public int getRegisterType() {
        return registerType;
    }

    public void setRegisterType(int registerType) {
        this.registerType = registerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginArea() {
        return lastLoginArea;
    }

    public void setLastLoginArea(String lastLoginArea) {
        this.lastLoginArea = lastLoginArea;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", lastLoginDate='" + lastLoginDate + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginArea='" + lastLoginArea + '\'' +
                ", memo='" + memo + '\'' +
                ", source='" + source + '\'' +
                ", orgId='" + orgId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
