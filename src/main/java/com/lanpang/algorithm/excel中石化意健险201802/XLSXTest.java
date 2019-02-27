package com.lanpang.algorithm.excel中石化意健险201802;

import java.io.*;
import java.util.*;

/**
 * @program: algorithm
 * @description: 刷数整理sql
 * @author: yanghao
 * @create: 2019-01-24 18:30
 **/
public class XLSXTest {
    /**
     *将读取的excel 中的单号整理，并且生成指定sql
     */
    public static void main(String[] args) {
        //1、读取excel中的单号
        //2、将所有单号放入map 去重
        //3、拼装sql
        //4、将sql写入 txt
        //2016.xlsx
        String pathname ="C:/Users/85416/Desktop/2018032513-【关于为核心业务系统增加境外业务标识的申请】的需求/境外标识清单（2015-2018）/中石化意健险2018-02.xls";
        String outTxtname ="C:/Users/85416/Desktop/2018032513-【关于为核心业务系统增加境外业务标识的申请】的需求/刷数sql/中石化意健险2018-02.txt";

        List readlist = ReadExcel.read(pathname);
        HashMap hashMap = setMap(readlist);
        Set<String> stringSet = makeSqlSet(hashMap);
        try {
            //将sql写入 txt
            writesqlToTxt(outTxtname,stringSet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //3、拼装sql
    public static Set<String> makeSqlSet(HashMap<String,String> hashMap){
        HashSet hashSet = new HashSet();
        for (Map.Entry<String,String> entry : hashMap.entrySet()) {
            //判断是保单还是批单
            if (entry.getKey().startsWith("3")) {
                String nationflag = getNationflag(entry.getValue());
                String sql = "update prpcmain p set p.nationflag='"+nationflag+"' where p.policyno='"+entry.getKey()+"';";
                hashSet.add(sql);
            }
            if (entry.getKey().startsWith("7")) {
                String nationflag = getNationflag(entry.getValue());
                String sql = "update prppmain p set p.nationflag='"+nationflag+"' where p.endorseno='"+entry.getKey()+"';";
                hashSet.add(sql);
            }
        }
        return hashSet;
    }

    /**
     * 根据中文Nationflag 获取编号
     * @param nationflagCN
     * @return
     */
    public static String getNationflag(String nationflagCN){
        String nationflag ="";
        if (nationflagCN.equals("中国利益境外业务")){
            nationflag = "0";
        }else if (nationflagCN.equals("境内业务")){
            nationflag = "1";
        }else if (nationflagCN.equals("非中国利益境外业务")){
            nationflag = "2";
        }
        return nationflag;
    }
    //2、将所有单号放入map 并去重
    public static HashMap setMap(List readlist){
        int num = 0;
        HashMap hashMap = new HashMap();
        for (Object object :readlist) {
            List<HashMap<String,String>> sheetList = (List<HashMap<String, String>>) object;
            for (HashMap<String,String> rowMap: sheetList) {
                for (Map.Entry<String,String> entry:rowMap.entrySet()){
                    num++;
                }
                hashMap.putAll(rowMap);
            }
        }
        System.out.println("共处理::::::"+num+"条数据");
        System.out.println("去除重复后得到::::::"+hashMap.size()+"条数据");
        return hashMap;
    }

    //将sql写入
    public static void writesqlToTxt(String outTxtname,Set<String> stringSet) throws IOException {
        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File(outTxtname));
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File(outTxtname)), "UTF-8"));
        for(String arr:stringSet){
            bw.write(arr+"\r\n");
        }
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }
}
