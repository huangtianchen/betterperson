package com.cmss.chenchangjun;
/**
 * 内存和cpu数量
 */
public class CpuAndMemory {
	//客户id
    public String customer_id;
    //cpu数量
    public int cpuCount;
    //内存数量
    public int memCount;
    //虚拟机数量
    public int vmCount;
    
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	public int getMemCount() {
		return memCount;
	}
	public void setMemCount(int memCount) {
		this.memCount = memCount;
	}
	public int getVmCount() {
		return vmCount;
	}
	public void setVmCount(int vmCount) {
		this.vmCount = vmCount;
	}
    
    
}
