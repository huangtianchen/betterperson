package com.cmss.chenchangjun;

import java.util.Date;

/**
 * 客户编码及资源信息
 */
public class ResourceCount {
    //客户编码
    private String boss_cust_id;
    //客户名称
    private String name;
    //部门名称
    private String dept;
    //客户联系人
    private String contactor;
    //客户联系人手机
    private String cont_phone;
    //客户联系人邮箱
    private String cont_email;
    //用户名
    private String user_name;
    //客户状态
    private String cust_status;
    //订单ID
    private String order_id;
    //订单项ID
    private String id;
    //订单项状态
    private String status;
    //资源类型
    private String type;
    //资源信息
    private String return_id;
    //创建时间
    private String order_time;
    //客户编码外键
    private String cmp_cust_id;

    public String getCmp_cust_id() {
		return cmp_cust_id;
	}

	public void setCmp_cust_id(String cmp_cust_id) {
		this.cmp_cust_id = cmp_cust_id;
	}

	public String getBoss_cust_id() {
        return boss_cust_id;
    }

    public void setBoss_cust_id(String boss_cust_id) {
        this.boss_cust_id = boss_cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getCont_phone() {
        return cont_phone;
    }

    public void setCont_phone(String cont_phone) {
        this.cont_phone = cont_phone;
    }

    public String getCont_email() {
        return cont_email;
    }

    public void setCont_email(String cont_email) {
        this.cont_email = cont_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCust_status() {
        return cust_status;
    }

    public void setCust_status(String cust_status) {
        this.cust_status = cust_status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReturn_id() {
        return return_id;
    }

    public void setReturn_id(String return_id) {
        this.return_id = return_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

}
