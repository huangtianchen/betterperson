package com.cmss.chenchangjun;
/**
 * 块存储总量
 */
public class Ebs {
   private String customer_id;
   private double ebsCount;
   public String getCustomer_id() {
	    return customer_id;
   }
   public void setCustomer_id(String customer_id) {
	    this.customer_id = customer_id;
   }
   public double getEbsCount() {
	    return ebsCount;
   }
   public void setEbsCount(Double ebsCount) {
	   this.ebsCount = ebsCount;
   }
}
