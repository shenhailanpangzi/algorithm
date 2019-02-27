package com.lanpang.algorithm.excel2018;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: yanghao
 * @create: 2019-01-24 18:46
 **/
public class ReadExcel {

    /**
     * 读取excel 返回list
     * @return
     */
    public static List read(String pathname) {
        try {
            List listexcel = new ArrayList();
            //同时支持Excel 2003、2007
            File excelFile = new File(pathname); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            //遍历每个Sheet  获得第1个sheet
            List<HashMap<String,String>> sheetMap1 = new ArrayList<>();
            Sheet sheet1 = workbook.getSheetAt(0);
            int rowCount = sheet1.getPhysicalNumberOfRows(); //获取总行数
            HashMap<String,String> rowMap1 = null;
            //遍历每一行  从第2行开始 统计每一条
                for (int r = 1; r < rowCount; r++) {
                    rowMap1 = new HashMap<String,String>();
                Row row = sheet1.getRow(r);
                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
                //遍历每一列  统计 第7列保单号 8列批单号 9列 标识
                    String policyno = row.getCell(6).getStringCellValue().replace(" ",""); //保单号
                    String endorseno = row.getCell(9).getStringCellValue().replace(" ",""); //批单号
                    String nationflag = row.getCell(10).getStringCellValue().replace(" ",""); //标识
                    if (!policyno.equals("")){
                        rowMap1.put(policyno,nationflag);
                    }
                    if (!endorseno.equals("")&&!endorseno.equals("0")){
                        rowMap1.put(endorseno,nationflag);
                    }
                    sheetMap1.add(rowMap1);
                System.out.println("policyno   "+policyno+"   nationflag   "+nationflag);
                }
            listexcel.add(sheetMap1);
            System.out.println("------------第一页统计完毕共："+sheetMap1.size()+"条");
            //遍历每个Sheet  获得第2个sheet
            List<HashMap<String,String>> sheetMap2 = new ArrayList<>();
            Sheet sheet2 = workbook.getSheetAt(1);
            int rowCount2 = sheet2.getPhysicalNumberOfRows(); //获取总行数
            HashMap<String,String> rowMap2 = null;
            //遍历每一行  从第2行开始 统计每一条
            for (int r = 1; r < rowCount2; r++) {
                rowMap2 = new HashMap<String,String> ();
                Row row = sheet2.getRow(r);
                //遍历每一列  统计 第7列保单号 8列批单号 9列 标识
                String policyno = row.getCell(4).getStringCellValue().replace(" ",""); //保单号
//                String endorseno = row.getCell(8).getStringCellValue().replace(" ",""); //批单号
                String nationflag = row.getCell(5).getStringCellValue().replace(" ",""); //标识
                if (!policyno.equals("")){
                    rowMap2.put(policyno,nationflag);
                }
//                if (!endorseno.equals("")){
//                    rowMap2.put(endorseno,nationflag);
//                }
                sheetMap2.add(rowMap2);
                System.out.println("policyno   "+policyno+"   nationflag   "+nationflag);
            }
            listexcel.add(sheetMap2);
            System.out.println("------------第二页统计完毕共："+sheetMap2.size()+"条");

            //遍历每个Sheet  获得第1个sheet
            List<HashMap<String,String>> sheetMap3 = new ArrayList<>();
            Sheet sheet3 = workbook.getSheetAt(2);
            int rowCount3 = sheet3.getPhysicalNumberOfRows(); //获取总行数
            HashMap<String,String> rowMap3 = null;
            //遍历每一行  从第2行开始 统计每一条
            for (int r = 1; r < rowCount3; r++) {
                rowMap3 = new HashMap<String,String>();
                Row row = sheet3.getRow(r);
                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
                //遍历每一列  统计 第7列保单号 8列批单号 9列 标识
                String policyno = row.getCell(0).getStringCellValue().replace(" ",""); //保单号
                String endorseno = row.getCell(3).getStringCellValue().replace(" ",""); //批单号
                String nationflag = row.getCell(2).getStringCellValue().replace(" ",""); //标识
                if (!policyno.equals("")){
                    rowMap3.put(policyno,nationflag);
                }
                if (!endorseno.equals("")&&!endorseno.equals("0")){
                    rowMap3.put(endorseno,nationflag);
                }
                sheetMap3.add(rowMap3);
                System.out.println("policyno   "+policyno+"   endorseno   "+endorseno+"   nationflag   "+nationflag);
            }
            listexcel.add(sheetMap3);
            System.out.println("------------第三页统计完毕共："+sheetMap3.size()+"条");
            return listexcel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
