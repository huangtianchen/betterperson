package com.cmss.chenchangjun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.extractor.ExcelExtractor;

/**
 * 功能描述:生成所需客户表及资源信息表
 * create by 陈长军 
 */
public class App {

    public static void main(String[] args) throws SQLException {
    	
        //连接mysql数据库的驱动  
    	String driver = "com.mysql.jdbc.Driver";
    	
    	  //本地数据库url
//        String url = "jdbc:mysql://localhost:3306/test"; 
    	  //直接连远程数据库的url
//        String url = "jdbc:mysql://localhost:20202/openstack";
//        String url = "jdbc:mysql://openstack.db.bcop.com:3306/openstack?useUnicode=true&characterEncoding=UTF-8";
//        String url = "jdbc:mysql://cloudmaster.db.bcop.com:3307/cloudmaster?useUnicode=true&characterEncoding=UTF-8";
          
          //通过堡垒机建立隧道连接代理服务器(通过Xshell建立隧道得到映射到本地的url)
          //主库
//    	String url = "jdbc:mysql://172.20.21.186:10992/cloudmaster?useUnicode=true&characterEncoding=UTF-8";
    	String url = "jdbc:mysql://172.20.21.186:10991/openstack?useUnicode=true&characterEncoding=UTF-8";
//    	String url = "jdbc:mysql://172.20.21.186:10987/cloudmaster?useUnicode=true&characterEncoding=UTF-8"
//        String url = "jdbc:mysql://localhost:20201/cloudmaster?useUnicode=true&characterEncoding=UTF-8";
          //资源库
//        String url = "jdbc:mysql://localhost:20202/openstack?useUnicode=true&characterEncoding=UTF-8";
          //Monitor库
//        String url = "jdbc:mysql://localhost:20203/monitor_alarm_openstack?useUnicode=true&characterEncoding=UTF-8";
          //本地数据库用户名及密码
//        String username = "root";
//        String password ="jun19921102";
          
          //主库用户名及密码
        String username = "test";
        String password ="XH@$H&ckP0UB";
          //资源库用户名及密码
//        String username = "";
//        String password="XH@$H&ckP0UB";
          
          //获取连接对象
          Connection conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
//        //查询客户订单及资源编码
//        String sql="SELECT "
//		+"c.BOSS_CUST_ID,c.NAME,'部门' AS dept,c.CONTACTOR,c.CONT_PHONE,u.EMAIL,u.USER_NAME,"
//		+"CASE c.CUST_STATUS WHEN 1 THEN '正常'"
//		+"WHEN 2 THEN '暂停'"
//		+"WHEN 6 THEN '已注销'"
//		+"ELSE '其他'"
//		+"END AS CUST_STATUS, o.ORDER_ID,e.ID,e.STATUS,'云主机' AS TYPE, ooei.RETURN_ID,e.ORDER_TIME,"
//		+"o.CMP_CUSTOMER_ID "
//		+"FROM opm_order o,opm_order_ext e,opm_resource_template ort,"
//		+"opm_resource_template_type ortt,opm_order_ext_instance ooei,"
//		+"opm_user_user u,opm_customer c "
//		+"WHERE o.ORDER_ID = e.ORDER_ID "
//		+"AND e.POOL_TEMPLATE_ID = ort.ID "
//		+"AND ort.RES_TYPE = ortt.ID "
//		+"AND e.ID = ooei.ORDER_EXT_ID "
//		+"AND o.CMP_CUSTOMER_ID = c.id "
//		+"AND u.customer_id = c.id "
//		+"AND u.IS_CUSTOMER = 1 "
//		+"AND ortt.TYPE_CODE = 'CIDC-RT-VM' "
//		+"AND c.id IN('CIDC-A-827873dfc3874488b8957e56a50ed711',"     
//		+"'CIDC-A-ee6770c284ac46c29dedbb1504213910',"
//		+"'CIDC-A-86a4f98d01b84d2abb21fafbf37aa13f',"
//		+"'CIDC-A-2d932a9821bd4dae9d9dc85f16785dae',"
//		+"'CIDC-A-2b089f8367f24c108c27137806861c84',"
//		+"'CIDC-A-0c9c25f75bc640b9b7ae0678d939ce85',"
//		+"'CIDC-A-b80230a13f4847efb5c52da93461b1bb',"
//		+"'CIDC-A-15ef3eedcd0343e69cd8761d75685b4b',"
//		+"'CIDC-A-e95968e2016c4cfeb3173c3088a9b8a5',"
//		+"'CIDC-A-75c96601fc3047798760431c3384b217',"
//		+"'CIDC-A-ea49c45d0be34d05bdeed83a7c4de4e4',"
//		+"'CIDC-A-f41366d2ac074155a6f79af28bc94ec4',"
//		+"'CIDC-A-0f542690932a40b9a543cec77aee29c1',"
//		+"'CIDC-A-582306f24f864d7d9463afe6ceff1a00',"
//		+"'CIDC-A-37707dbfb2e545b2998232edf13cf38a',"
//		+"'CIDC-A-7ad0b2be57c348f5a8f4819b46b42b72',"
//		+"'CIDC-A-9dad186e5bcb4dca94b81fa70d7268c4',"
//		+"'CIDC-A-bd1ccd8cfa734c8d8fa3caa02365fde8',"
//		+"'CIDC-A-08331d948c69449ba39238817a23ebf8',"
//		+"'CIDC-A-2a46313430324c6a9584aeaa867d7080',"
//		+"'CIDC-A-667ffa71f7874ac291da1c05770bef2b',"
//		+"'CIDC-A-027623709425478eb8d0683798e64148',"
//		+"'CIDC-A-e37e3d1ee4294c5c92608b548c459bf8',"
//		+"'CIDC-A-5663e6e7631a46d986d3768ef43b8307',"
//		+"'CIDC-A-e2536503846e4fbd83b4486b90640c73',"
//		+"'CIDC-A-760be71a7bfa42398346adee3a0e206e',"
//		+"'CIDC-A-320c2d961a17454b9080729c25bcea36',"
//		+"'CIDC-A-c43792f85c694105aba1a55c9c372890',"
//		+"'CIDC-A-77aca4bc9d404e9ba47f0e7461085266',"
//		+"'CIDC-A-3bdfda32366742b2aade1c2cbf081050',"
//		+"'CIDC-A-bb502190a3db4112ba6372b683dfdeac',"
//		+"'CIDC-A-50f0b5aeff0f438a8dd9da9931d33e1a',"
//		+"'CIDC-A-30c96dbe3b3d4e97843f311a683d30f3',"
//		+"'CIDC-A-3a07dc09a232441b89373989258c5802',"
//		+"'CIDC-A-9cfcb2be5351480f9324571adffbd485',"
//		+"'CIDC-A-a243bcde43e04a75b5333ae634187c4a',"
//		+"'CIDC-A-15a6a253ab9d4b3bb971dc167c6b88c7',"
//		+"'CIDC-A-8c4aa9b9e8e243f3b410faec7b817536',"
//		+"'CIDC-A-8201fcd85c944fbf9ea50f3bf2c8c3f6',"
//		+"'CIDC-A-f7cdd2dd53664225ba1bfbc3f82035ae',"
//		+"'CIDC-A-469dbe4fa5a348e28c745abe4175759e',"
//		+"'CIDC-A-f2816a41e9a34153949123ae8c5fd2db',"
//		+"'CIDC-A-e6a72a22fe304126af853deb21bcd79f',"
//		+"'CIDC-A-68872646abcc4d46bb486cc50ac3a64b',"
//		+"'CIDC-A-26c7a050fbd1477a89627218e393bb0e',"
//		+"'CIDC-A-be9f03ceb9ce4e58a4c3150759bd647d',"
//		+"'CIDC-A-cf79dc36cfb94c6c9ba9dc48fbf6c44b',"
//		+"'CIDC-A-d55b4e071beb42a2af3940df83842e91',"
//		+"'CIDC-A-dae2650a011b4a1aa4e7cdb7121ab7ea',"
//		+"'CIDC-A-95ab4d7e6ca640f9a858c873ffd58279',"
//		+"'CIDC-A-50834736edf248ddbaf348483eeb4238',"
//		+"'CIDC-A-0b87f535284b4d1d88a44196518e90cb',"
//		+"'CIDC-A-b85fd7baecf949998191573b84591df7',"
//		+"'CIDC-A-91be25bee7aa4c8a8b5db1791c253a03',"
//		+"'CIDC-A-321455088fad4f528cb549a899e2708a',"
//		+"'CIDC-A-474e4bcb86334b8c8d73442412f15a90',"
//		+"'CIDC-A-250972b6bf46499383b9d6477f09b8f1',"
//		+"'CIDC-A-bae4e6c976674e00bba5dea2a8a36f36',"
//		+"'CIDC-A-56dbfbad18e24948b3fb396a5ce710a9',"
//		+"'CIDC-A-c814c5675a1a435f9d546a203805cbbc',"
//		+"'CIDC-A-ba4a1b44dbc04236bddff0452ebc7a74',"
//		+"'CIDC-A-bc4aa38a1b5e460db4cc9d9617ef0734',"
//		+"'CIDC-A-edcd1d6479814fa298e004e4a4855e5d',"
//		+"'CIDC-A-ec83c7a9acfb45ce97dcf303cf620c8c',"
//		+"'CIDC-A-55b6035123644dc8abeb7ee4d689706b',"
//		+"'CIDC-A-bcb5ff5404444f0bb436c7eaecc84df3',"
//		+"'CIDC-A-4fd071120c024a48acafc33e2dbcac08',"
//		+"'CIDC-A-81404b5769b04032b4cefa9baef906bf',"
//		+"'CIDC-A-955c9f913f264e7f8212a1aa7a90982a',"
//		+"'CIDC-A-e6c4639e10dd433aa73023be96183be3',"
//		+"'CIDC-A-fad87757c33042d1a071791a6902c0ca',"
//		+"'CIDC-A-429891f581da4394a7cb8890e31c22d9',"
//		+"'CIDC-A-bf2c0b86f7524fbe8cda1afdedda99ad')";
        
//        //查询cpu及内存
//        String sql = "SELECT "+ 
//        "vm.`CUSTOMER_ID`, SUM(vm.`VCPU`), SUM(vm.`VMEMORY`), COUNT(vm.`ID`)"
//        +"FROM `os_biz_vm_host` vm "
//        +"WHERE vm.`IS_DELETE` = 0 "
//        +"AND vm.`CUSTOMER_ID` IN("
//        +"'CIDC-A-827873dfc3874488b8957e56a50ed711',"     
//        +"'CIDC-A-ee6770c284ac46c29dedbb1504213910',"
//        +"'CIDC-A-86a4f98d01b84d2abb21fafbf37aa13f',"
//        +"'CIDC-A-2d932a9821bd4dae9d9dc85f16785dae',"
//        +"'CIDC-A-2b089f8367f24c108c27137806861c84',"
//        +"'CIDC-A-0c9c25f75bc640b9b7ae0678d939ce85',"
//        +"'CIDC-A-b80230a13f4847efb5c52da93461b1bb',"
//        +"'CIDC-A-15ef3eedcd0343e69cd8761d75685b4b',"
//        +"'CIDC-A-e95968e2016c4cfeb3173c3088a9b8a5',"
//        +"'CIDC-A-75c96601fc3047798760431c3384b217',"
//        +"'CIDC-A-ea49c45d0be34d05bdeed83a7c4de4e4',"
//        +"'CIDC-A-f41366d2ac074155a6f79af28bc94ec4',"
//        +"'CIDC-A-0f542690932a40b9a543cec77aee29c1',"
//        +"'CIDC-A-582306f24f864d7d9463afe6ceff1a00',"
//        +"'CIDC-A-37707dbfb2e545b2998232edf13cf38a',"
//        +"'CIDC-A-7ad0b2be57c348f5a8f4819b46b42b72',"
//        +"'CIDC-A-9dad186e5bcb4dca94b81fa70d7268c4',"
//        +"'CIDC-A-bd1ccd8cfa734c8d8fa3caa02365fde8',"
//        +"'CIDC-A-08331d948c69449ba39238817a23ebf8',"
//        +"'CIDC-A-2a46313430324c6a9584aeaa867d7080',"
//        +"'CIDC-A-667ffa71f7874ac291da1c05770bef2b',"
//        +"'CIDC-A-027623709425478eb8d0683798e64148',"
//        +"'CIDC-A-e37e3d1ee4294c5c92608b548c459bf8',"
//        +"'CIDC-A-5663e6e7631a46d986d3768ef43b8307',"
//        +"'CIDC-A-e2536503846e4fbd83b4486b90640c73',"
//        +"'CIDC-A-760be71a7bfa42398346adee3a0e206e',"
//        +"'CIDC-A-320c2d961a17454b9080729c25bcea36',"
//        +"'CIDC-A-c43792f85c694105aba1a55c9c372890',"
//        +"'CIDC-A-77aca4bc9d404e9ba47f0e7461085266',"
//        +"'CIDC-A-3bdfda32366742b2aade1c2cbf081050',"
//        +"'CIDC-A-bb502190a3db4112ba6372b683dfdeac',"
//        +"'CIDC-A-50f0b5aeff0f438a8dd9da9931d33e1a',"
//        +"'CIDC-A-30c96dbe3b3d4e97843f311a683d30f3',"
//        +"'CIDC-A-3a07dc09a232441b89373989258c5802',"
//        +"'CIDC-A-9cfcb2be5351480f9324571adffbd485',"
//        +"'CIDC-A-a243bcde43e04a75b5333ae634187c4a',"
//        +"'CIDC-A-15a6a253ab9d4b3bb971dc167c6b88c7',"
//        +"'CIDC-A-8c4aa9b9e8e243f3b410faec7b817536',"
//        +"'CIDC-A-8201fcd85c944fbf9ea50f3bf2c8c3f6',"
//        +"'CIDC-A-f7cdd2dd53664225ba1bfbc3f82035ae',"
//        +"'CIDC-A-469dbe4fa5a348e28c745abe4175759e',"
//        +"'CIDC-A-f2816a41e9a34153949123ae8c5fd2db',"
//        +"'CIDC-A-e6a72a22fe304126af853deb21bcd79f',"
//        +"'CIDC-A-68872646abcc4d46bb486cc50ac3a64b',"
//        +"'CIDC-A-26c7a050fbd1477a89627218e393bb0e',"
//        +"'CIDC-A-be9f03ceb9ce4e58a4c3150759bd647d',"
//        +"'CIDC-A-cf79dc36cfb94c6c9ba9dc48fbf6c44b',"
//        +"'CIDC-A-d55b4e071beb42a2af3940df83842e91',"
//        +"'CIDC-A-dae2650a011b4a1aa4e7cdb7121ab7ea',"
//        +"'CIDC-A-95ab4d7e6ca640f9a858c873ffd58279',"
//        +"'CIDC-A-50834736edf248ddbaf348483eeb4238',"
//        +"'CIDC-A-0b87f535284b4d1d88a44196518e90cb',"
//        +"'CIDC-A-b85fd7baecf949998191573b84591df7',"
//        +"'CIDC-A-91be25bee7aa4c8a8b5db1791c253a03',"
//        +"'CIDC-A-321455088fad4f528cb549a899e2708a',"
//        +"'CIDC-A-474e4bcb86334b8c8d73442412f15a90',"
//        +"'CIDC-A-250972b6bf46499383b9d6477f09b8f1',"
//        +"'CIDC-A-bae4e6c976674e00bba5dea2a8a36f36',"
//        +"'CIDC-A-56dbfbad18e24948b3fb396a5ce710a9',"
//        +"'CIDC-A-c814c5675a1a435f9d546a203805cbbc',"
//        +"'CIDC-A-ba4a1b44dbc04236bddff0452ebc7a74',"
//        +"'CIDC-A-bc4aa38a1b5e460db4cc9d9617ef0734',"
//        +"'CIDC-A-edcd1d6479814fa298e004e4a4855e5d',"
//        +"'CIDC-A-ec83c7a9acfb45ce97dcf303cf620c8c',"
//        +"'CIDC-A-55b6035123644dc8abeb7ee4d689706b',"
//        +"'CIDC-A-bcb5ff5404444f0bb436c7eaecc84df3',"
//        +"'CIDC-A-4fd071120c024a48acafc33e2dbcac08',"
//        +"'CIDC-A-81404b5769b04032b4cefa9baef906bf',"
//        +"'CIDC-A-955c9f913f264e7f8212a1aa7a90982a',"
//        +"'CIDC-A-e6c4639e10dd433aa73023be96183be3',"
//        +"'CIDC-A-fad87757c33042d1a071791a6902c0ca',"
//        +"'CIDC-A-429891f581da4394a7cb8890e31c22d9',"
//        +"'CIDC-A-bf2c0b86f7524fbe8cda1afdedda99ad')"
//        +"GROUP BY vm.`CUSTOMER_ID`";
        
      //计算存储数量
      String sql = "SELECT " 
      +"bs.`CUSTOMER_ID`, cast(SUM(bs.`SIZE`)as DECIMAL(10,4))"
      +"FROM  `os_biz_ebs` bs "
      +"WHERE bs.`IS_DELETE` = 0 "
      +"AND bs.`CUSTOMER_ID` IN("
      +"'CIDC-A-827873dfc3874488b8957e56a50ed711',"     
      +"'CIDC-A-ee6770c284ac46c29dedbb1504213910',"
		+"'CIDC-A-86a4f98d01b84d2abb21fafbf37aa13f',"
		+"'CIDC-A-2d932a9821bd4dae9d9dc85f16785dae',"
		+"'CIDC-A-2b089f8367f24c108c27137806861c84',"
		+"'CIDC-A-0c9c25f75bc640b9b7ae0678d939ce85',"
		+"'CIDC-A-b80230a13f4847efb5c52da93461b1bb',"
	    +"'CIDC-A-15ef3eedcd0343e69cd8761d75685b4b',"
		+"'CIDC-A-e95968e2016c4cfeb3173c3088a9b8a5',"
		+"'CIDC-A-75c96601fc3047798760431c3384b217',"
		+"'CIDC-A-ea49c45d0be34d05bdeed83a7c4de4e4',"
		+"'CIDC-A-f41366d2ac074155a6f79af28bc94ec4',"
		+"'CIDC-A-0f542690932a40b9a543cec77aee29c1',"
	    +"'CIDC-A-582306f24f864d7d9463afe6ceff1a00',"
		+"'CIDC-A-37707dbfb2e545b2998232edf13cf38a',"
		+"'CIDC-A-7ad0b2be57c348f5a8f4819b46b42b72',"
		+"'CIDC-A-9dad186e5bcb4dca94b81fa70d7268c4',"
		+"'CIDC-A-bd1ccd8cfa734c8d8fa3caa02365fde8',"
		+"'CIDC-A-08331d948c69449ba39238817a23ebf8',"
		+"'CIDC-A-2a46313430324c6a9584aeaa867d7080',"
		+"'CIDC-A-667ffa71f7874ac291da1c05770bef2b',"
		+"'CIDC-A-027623709425478eb8d0683798e64148',"
		+"'CIDC-A-e37e3d1ee4294c5c92608b548c459bf8',"
		+"'CIDC-A-5663e6e7631a46d986d3768ef43b8307',"
		+"'CIDC-A-e2536503846e4fbd83b4486b90640c73',"
		+"'CIDC-A-760be71a7bfa42398346adee3a0e206e',"
		+"'CIDC-A-320c2d961a17454b9080729c25bcea36',"
		+"'CIDC-A-c43792f85c694105aba1a55c9c372890',"
		+"'CIDC-A-77aca4bc9d404e9ba47f0e7461085266',"
		+"'CIDC-A-3bdfda32366742b2aade1c2cbf081050',"
		+"'CIDC-A-bb502190a3db4112ba6372b683dfdeac',"
		+"'CIDC-A-50f0b5aeff0f438a8dd9da9931d33e1a',"
		+"'CIDC-A-30c96dbe3b3d4e97843f311a683d30f3',"
		+"'CIDC-A-3a07dc09a232441b89373989258c5802',"
		+"'CIDC-A-9cfcb2be5351480f9324571adffbd485',"
		+"'CIDC-A-a243bcde43e04a75b5333ae634187c4a',"
		+"'CIDC-A-15a6a253ab9d4b3bb971dc167c6b88c7',"
		+"'CIDC-A-8c4aa9b9e8e243f3b410faec7b817536',"
		+"'CIDC-A-8201fcd85c944fbf9ea50f3bf2c8c3f6',"
		+"'CIDC-A-f7cdd2dd53664225ba1bfbc3f82035ae',"
		+"'CIDC-A-469dbe4fa5a348e28c745abe4175759e',"
		+"'CIDC-A-f2816a41e9a34153949123ae8c5fd2db',"
		+"'CIDC-A-e6a72a22fe304126af853deb21bcd79f',"
		+"'CIDC-A-68872646abcc4d46bb486cc50ac3a64b',"
		+"'CIDC-A-26c7a050fbd1477a89627218e393bb0e',"
		+"'CIDC-A-be9f03ceb9ce4e58a4c3150759bd647d',"
		+"'CIDC-A-cf79dc36cfb94c6c9ba9dc48fbf6c44b',"
		+"'CIDC-A-d55b4e071beb42a2af3940df83842e91',"
		+"'CIDC-A-dae2650a011b4a1aa4e7cdb7121ab7ea',"
		+"'CIDC-A-95ab4d7e6ca640f9a858c873ffd58279',"
		+"'CIDC-A-50834736edf248ddbaf348483eeb4238',"
		+"'CIDC-A-0b87f535284b4d1d88a44196518e90cb',"
		+"'CIDC-A-b85fd7baecf949998191573b84591df7',"
		+"'CIDC-A-91be25bee7aa4c8a8b5db1791c253a03',"
		+"'CIDC-A-321455088fad4f528cb549a899e2708a',"
		+"'CIDC-A-474e4bcb86334b8c8d73442412f15a90',"
		+"'CIDC-A-250972b6bf46499383b9d6477f09b8f1',"
		+"'CIDC-A-bae4e6c976674e00bba5dea2a8a36f36',"
		+"'CIDC-A-56dbfbad18e24948b3fb396a5ce710a9',"
		+"'CIDC-A-c814c5675a1a435f9d546a203805cbbc',"
		+"'CIDC-A-ba4a1b44dbc04236bddff0452ebc7a74',"
		+"'CIDC-A-bc4aa38a1b5e460db4cc9d9617ef0734',"
		+"'CIDC-A-edcd1d6479814fa298e004e4a4855e5d',"
		+"'CIDC-A-ec83c7a9acfb45ce97dcf303cf620c8c',"
		+"'CIDC-A-55b6035123644dc8abeb7ee4d689706b',"
		+"'CIDC-A-bcb5ff5404444f0bb436c7eaecc84df3',"
		+"'CIDC-A-4fd071120c024a48acafc33e2dbcac08',"
		+"'CIDC-A-81404b5769b04032b4cefa9baef906bf',"
		+"'CIDC-A-955c9f913f264e7f8212a1aa7a90982a',"
		+"'CIDC-A-e6c4639e10dd433aa73023be96183be3',"
		+"'CIDC-A-fad87757c33042d1a071791a6902c0ca',"
		+"'CIDC-A-429891f581da4394a7cb8890e31c22d9',"
		+"'CIDC-A-bf2c0b86f7524fbe8cda1afdedda99ad')"
		+"GROUP BY bs.`CUSTOMER_ID`";
        
        //查询资源信息表，导入本地库之后计算。(注:执行此sql之前得新增hour列,用于group每小时数据)
//        String sql = "SELECT x.客户编码, x.客户名称, x.部门名称, x.客户联系人, x.客户联系人手机, x.客户联系人邮箱, x.用户名, x.客户状态, x.订单ID, " 
//        		+"x.订单项ID, x.订单项状态, x.资源类型, x.资源信息, x.创建时间, x.客户编码外键, x.cpu, x.Mcpu, m.mem, m.Mmem "
//                +"from (select * from (select * FROM resourcecount )AS cc LEFT JOIN ("
//        		+"SELECT cast(AVG(h.avgcpu)as DECIMAL(10,2))as cpu,cast(AVG(h.newcpu)as DECIMAL(10,2))as Mcpu,"
//        		+"h.vmid AS newvmid FROM (SELECT MAX(vm.processor_used) AS newcpu, AVG(vm.processor_used) AS avgcpu, "
//        		+"vm.VM_ID AS vmid FROM  sheet4 vm GROUP BY vm.hour) AS h GROUP BY h.vmid) AS n ON "
//        		+"cc.资源信息 = n.newvmid) AS x left join (SELECT cast(AVG(h.avgmem)as DECIMAL(10,2))as mem,"
//        		+"cast(AVG(h.newmem)as DECIMAL(10,2))as Mmem,h.vmid AS newvmid FROM ("
//                +"SELECT MAX(vm.MEM_USED) AS newmem, AVG(vm.MEM_USED) AS avgmem, vm.VM_ID AS vmid FROM sheet4 vm " 
//                +"GROUP BY vm.hour) AS h GROUP BY h.vmid) AS m on x.资源信息  = m.newvmid";
        
//        //查询客户表，在本地库进行计算(注：在资源信息表导入本地库之后进行)。
//        String sql = "select * from (select * from (SELECT y.客户名称 AS 客户名称, y.客户编码 AS 客户编码, cast(AVG(y.cpu) AS DECIMAL(10,2)) AS CPU均值使用率,"
//        		 +"CAST(AVG(y.Mcpu) AS DECIMAL(10,2)) AS CPU峰值均值使用率,"
//        		 +"CAST(AVG(y.mem) AS DECIMAL(10,2)) AS 内存均值使用率, CAST(AVG(y.Mmem) AS DECIMAL(10,2)) AS 内存峰值均值使用率, y.客户编码外键 "
//        		 +"FROM 资源信息表 AS y GROUP BY y.客户名称) AS o left join cpuandmemory on o.客户编码外键 = cpuandmemory.客户编码外键1) AS q "
//        		 +"left join ebs on q.客户编码外键 = ebs.客户编码外键2";       
        
        PreparedStatement pres = null;

        try {
            pres = conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //查询数据库得到的结果集
        ResultSet resultSet = pres.executeQuery();
        
        //将查询到的结果放到list集合中
//      List<ResourceCount> list = new ArrayList<ResourceCount>();
//      List<CpuAndMemory> list = new ArrayList<CpuAndMemory>();
      List<Ebs> list = new ArrayList<Ebs>();
        //查询出的资源信息表结果集放入list中
//      List<ResourceInformation> list = new ArrayList<>();
        //查询出的客户表结果放入list中
//        List<CustomerResourceCount> list = new ArrayList<>();
        
        while(resultSet.next())
        {     
//        //资源统计
//        ResourceCount ss=new ResourceCount();
//        ss.setBoss_cust_id(resultSet.getString(1));
//        ss.setName(resultSet.getString(2));
//        ss.setDept(resultSet.getString(3));
//        ss.setContactor(resultSet.getString(4));
//        ss.setCont_phone(resultSet.getString(5));
//        ss.setCont_email(resultSet.getString(6));
//        ss.setUser_name(resultSet.getString(7));
//        ss.setCust_status(resultSet.getString(8));
//        ss.setOrder_id(resultSet.getString(9));
//        ss.setId(resultSet.getString(10));
//        ss.setStatus(resultSet.getString(11));
//        ss.setType(resultSet.getString(12));
//        ss.setReturn_id(resultSet.getString(13));
//        ss.setOrder_time(resultSet.getString(14));
//        ss.setCmp_cust_id(resultSet.getString(15));
                     
//      //CPU和Mem数量统计
//      CpuAndMemory ss=new CpuAndMemory();
//      ss.setCustomer_id(resultSet.getString(1));
//      ss.setCpuCount(resultSet.getInt(2));
//      ss.setMemCount(resultSet.getInt(3));
//      ss.setVmCount(resultSet.getInt(4));
            
      //存储数量统计
      Ebs ss=new Ebs();
      ss.setCustomer_id(resultSet.getString(1));
      ss.setEbsCount(resultSet.getDouble(2));
      
      //资源信息统计
//	    ResourceInformation ss = new ResourceInformation();
//	    ss.setBoss_cust_id(resultSet.getString(1));
//	    ss.setName(resultSet.getString(2));
//	    ss.setDept(resultSet.getString(3));
//	    ss.setContactor(resultSet.getString(4));
//	    ss.setCont_phone(resultSet.getString(5));
//	    ss.setCont_email(resultSet.getString(6));
//	    ss.setUser_name(resultSet.getString(7));
//	    ss.setCust_status(resultSet.getString(8));
//	    ss.setOrder_id(resultSet.getString(9));
//	    ss.setId(resultSet.getString(10));
//	    ss.setStatus(resultSet.getString(11));
//	    ss.setType(resultSet.getString(12));
//	    ss.setReturn_id(resultSet.getString(13));
//	    ss.setOrder_time(resultSet.getString(14));
//	    ss.setCmp_cust_id(resultSet.getString(15));
//	    ss.setCpu(resultSet.getDouble(16));
//	    ss.setMcpu(resultSet.getDouble(17));
//	    ss.setMem(resultSet.getDouble(18));
//	    ss.setMmem(resultSet.getDouble(19));
        	
//        //客户统计
//      CustomerResourceCount ss=new CustomerResourceCount();
//      ss.setBoss_cust_id(resultSet.getString(1));
//      ss.setName(resultSet.getString(2));
//      ss.setCpu(resultSet.getDouble(3));
//      ss.setMcpu(resultSet.getDouble(4));
//      ss.setMem(resultSet.getDouble(5));
//      ss.setMmem(resultSet.getDouble(6));
//      ss.setCmp_cust_id(resultSet.getString(7));
//      ss.setCmp_cust_id1(resultSet.getString(8));
//      ss.setCpuCount(resultSet.getInt(9));
//      ss.setMemSize(resultSet.getInt(10));
//      ss.setVmCount(resultSet.getInt(11));
//      ss.setCmp_cust_id2(resultSet.getString(12));
//      ss.setBlockStorageCount(resultSet.getDouble(13));
      
        list.add(ss);
        }
        
//        //表头
//      String[] headers = {"客户编码","客户名称","部门名称","客户联系人","客户联系人手机","客户联系人邮箱","用户名",
//                         "客户状态","订单ID","订单项ID","订单项状态","资源类型","资源信息","创建时间","客户编码外键"};   
//      String[] headers = {"客户编码外键1","CPU数量","内存数量","虚拟机数量"};
      String[] headers = {"客户编码外键2","存储数量"};
        //资源信息表表头
//      String[] headers = {"客户编码","客户名称","部门名称","客户联系人","客户联系人手机","客户联系人邮箱","用户名",
//                         "客户状态","订单ID","订单项ID","订单项状态","资源类型","资源信息","创建时间","客户编码外键",
//                         "CPU均值使用率","CPU峰值均值使用率","内存均值使用率","内存峰值均值使用率"};
        //客户表表头
//      String[] headers = {"客户编码","客户名称","CPU均值使用率","CPU峰值均值使用率","内存均值使用率","内存峰值均值使用率","客户编码外键","客户编码外键1",
//        		           "CPU数目","内存大小","已申请云主机数目","客户编码外键2","块存储总量"};
          
        //得到excel表格对象
//      ExportExcel<ResourceCount> excel = new ExportExcel<ResourceCount>();
//      ExportExcel<CpuAndMemory> excel = new ExportExcel<CpuAndMemory>();
      ExportExcel<Ebs> excel = new ExportExcel<Ebs>();
//      ExportExcel<ResourceInformation> excel = new ExportExcel<ResourceInformation>();
//        ExportExcel<CustomerResourceCount> excel = new ExportExcel<CustomerResourceCount>();
        
        //生成excel表格
//      excel.exportExcel(headers,list, "ResourceCount");
//      excel.exportExcel(headers,list, "CpuAndMemory");
      excel.exportExcel(headers,list, "Ebs"); 
//      excel.exportExcel(headers, list, "ResourceInformation");
//        excel.exportExcel(headers,list, "CustomerResourceCount");
    }
      
}