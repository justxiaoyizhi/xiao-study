package com.xyz.company.xiao20180103;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by xuxp on 2017/7/14.
 */
public class HBaseCase {
    // 声明静态配置
    static Configuration conf = null;

    static {
        conf = HBaseConfiguration.create();
    }

    public static void main(String[] args) throws Exception {
//        creatTable("person", new String[]{"name", "age"});
        addData("rk00001","user", new String[]{"page_name", "error_msg"}, new String[]{""});
    }


    /*
     * 创建表
     *
     * @tableName 表名
     *
     * @family 列族列表
     */
    public static void creatTable(String tableName, String[] family)
            throws Exception {
        HBaseAdmin admin = new HBaseAdmin(conf);
        HTableDescriptor desc = new HTableDescriptor(tableName);
        for (int i = 0; i < family.length; i++) {
            desc.addFamily(new HColumnDescriptor(family[i]));
        }
        if (admin.tableExists(tableName)) {
            System.out.println("table Exists!");
            System.exit(0);
        } else {
            admin.createTable(desc);
            System.out.println("create table Success!");
        }
    }


    /*
     * 为表添加数据（适合知道有多少列族的固定表）
     *
     * @rowKey rowKey
     *
     * @tableName 表名
     *
     * @column1 第一个列族列表
     *
     * @value1 第一个列的值的列表
     *
     */
    public static void addData(String rowKey, String tableName, String[] column, String[] value)
            throws IOException {
        Put put = new Put(Bytes.toBytes(rowKey));// 设置rowkey
        HTable table = new HTable(conf, Bytes.toBytes(tableName));// HTabel负责跟记录相关的操作如增删改查等//

        for (int j = 0; j < column.length; j++) {
            put.add(Bytes.toBytes("error_msg"), Bytes.toBytes(column[j]), Bytes.toBytes(value[j]));
        }
        table.put(put);
        System.out.println("add data Success!");
    }
}
