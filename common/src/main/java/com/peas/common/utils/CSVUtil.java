/*
 * 版权所有 @2014 浙江双琪电子商务有限公司。保留所有权利
 * 双琪电商平台（sqec-plat）
 */

package com.peas.common.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
 * CSVUtil 工具类，简单读写，不包含复杂操作内容
 *
 * @author：Mr.X 2015年9月14日 下午12:26:59
 */
public class CSVUtil {


  /**
   * 读取CSV文件
   * 
   * @param filePath 文件物理地址
   * @param isReadHead 是否读取头文件
   * @return List<String[]>
   */
  public static List<String[]> readeCsv(String filePath, Boolean isReadHead) {

    List<String[]> csvList = new ArrayList<String[]>(); // 用来保存数据

    try {


      /*
       * 1.文件流（上传）
       * MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
       * MultipartFile file = multipartRequest.getFile("fileUpload");
       * InputStream input = file.getInputStream();
       * CsvReader reader = new CsvReader(input,',',Charset.forName("GBK"));
       */
      
      String csvFilePath = filePath;
      CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("GBK")); // 一般用这编码读就可以了

      if (!isReadHead) {
        reader.readHeaders(); // 跳过表头 如果需要表头的话，不要写这句。
      }

      while (reader.readRecord()) { // 逐行读入除
        csvList.add(reader.getValues());
      }
      reader.close();

      /*
       * for (int row = 0; row < csvList.size(); row++) {
       * String cell = csvList.get(row)[0]; // 取得第row行第0列的数据
       * System.out.println(cell);
       * }
       */
    } catch (Exception ex) {
      System.out.println(ex);
    }

    return csvList;
  }

  /**
   * 写入CSV文件
   * 
   * @param filePath 文件物理地址
   * @param csvList 文件内容(头内容，和数据内容一样写入)
   */
  public static void writeCsv(String filePath, List<String[]> csvList) {
    try {

      String csvFilePath = filePath;
      CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("GBK"));

      for (String[] content : csvList) {
        wr.writeRecord(content); // 循环写入
      }

      wr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {

    List<String[]> list = new ArrayList<String[]>();

    for (int i = 0; i < 10; i++) {

      String[] strs = new String[10];

      for (int j = 0; j < strs.length; j++) {
        strs[j] = j + "内容";
      }
      list.add(strs);
    }

    writeCsv("d:/Mr.X.csv", list);

  }


}
