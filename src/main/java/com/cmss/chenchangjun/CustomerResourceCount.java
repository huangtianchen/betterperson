package com.cmss.chenchangjun;
/**
 * 客户表
 */
public class CustomerResourceCount {
    //客户编码
	private String boss_cust_id;
	//客户名称
    private String name;
    //CPU均值使用率
    private double cpu;
    //CPU峰值均值使用率
    private double Mcpu;
    //内存均值使用率
    private double mem;
    //内存峰值均值使用率
    private double Mmem;
    //客户编码外键
    private String cmp_cust_id;
    //客户编码外键1
    private String cmp_cust_id1;
    //CPU数目
    private int cpuCount;
    //内存大小
    private int memSize;
    //已申请云主机数目
    private int vmCount;
    //客户编码外键2
    private String cmp_cust_id2;
    //块存储总量
    private double blockStorageCount;
    
	public String getBoss_cust_id() {
		return boss_cust_id;
	}
	public double getCpu() {
		return cpu;
	}
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	public double getMcpu() {
		return Mcpu;
	}
	public void setMcpu(double mcpu) {
		Mcpu = mcpu;
	}
	public double getMem() {
		return mem;
	}
	public void setMem(double mem) {
		this.mem = mem;
	}
	public double getMmem() {
		return Mmem;
	}
	public void setMmem(double mmem) {
		Mmem = mmem;
	}
	public String getCmp_cust_id() {
		return cmp_cust_id;
	}
	public void setCmp_cust_id(String cmp_cust_id) {
		this.cmp_cust_id = cmp_cust_id;
	}
	public String getCmp_cust_id1() {
		return cmp_cust_id1;
	}
	public void setCmp_cust_id1(String cmp_cust_id1) {
		this.cmp_cust_id1 = cmp_cust_id1;
	}
	public int getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	public int getMemSize() {
		return memSize;
	}
	public void setMemSize(int memSize) {
		this.memSize = memSize;
	}
	public int getVmCount() {
		return vmCount;
	}
	public void setVmCount(int vmCount) {
		this.vmCount = vmCount;
	}
	public String getCmp_cust_id2() {
		return cmp_cust_id2;
	}
	public void setCmp_cust_id2(String cmp_cust_id2) {
		this.cmp_cust_id2 = cmp_cust_id2;
	}
	public double getBlockStorageCount() {
		return blockStorageCount;
	}
	public void setBlockStorageCount(double blockStorageCount) {
		this.blockStorageCount = blockStorageCount;
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
  
}
